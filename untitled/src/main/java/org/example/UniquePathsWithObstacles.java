package org.example;

public class UniquePathsWithObstacles {
    public static void main(String... args) {
        int[][] A
                = { { 0, -1, 0 },
                    { 0, 0, 0 },
                    { 0, 0, 0 } };

        System.out.println(uniquePathsWithObstacles(A));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i = 1; i < obstacleGrid.length; ++i) {
                if (obstacleGrid[i][0] == -1) {
                    obstacleGrid[i][0] = 0;
                } else {
                    obstacleGrid[i][0] = obstacleGrid[i - 1][0];
                }
        }

        for (int i = 1; i < obstacleGrid[0].length; ++i) {
            if (obstacleGrid[0][i] == -1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }

        for (int i = 1; i < obstacleGrid.length; ++i) {
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[i][j] == -1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        // The bottom-right corner contains the result
        return obstacleGrid[m - 1][n - 1];
    }
}
