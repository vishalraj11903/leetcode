package practice;

public class LargestArea {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {1, -1}, {1, -1}, {1, 1}};
    static int[][] dirs= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String... args) {
        int[][] input = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
        };

        place2s(input);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    max = dfs(input, i, j);
                }
            }
        }
        System.out.println(max);
    }


    static int dfs(int[][] input, int x, int y) {
        input[x][y] = -1;
        int count = 0;
        for (int[] dir : dirs) {
            int row = x + dir[0];
            int col = y + dir[1];
            if (row >= 0 && col >= 0 && row < input.length && col < input[0].length
                    && input[row][col] == 0) {
                count = dfs(input, row, col) + 1;
            }
        }

        return count;
    }

    static void place2s(int[][] input) {
        for (int i = 1; i < input.length - 1; ++i) {
            for (int j = 1; j < input[0].length - 1; ++j) {
                if (input[i][j] == 1) {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (input[x][y] == 0) {
                            input[x][y] = 2;
                        }
                    }
                }
            }
        }
    }

}
