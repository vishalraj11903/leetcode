package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInMatrix {
    static int[][] direction = new int[][] {
            {-1, 0, 'U'},
            {1, 0, 'D'},
            {0, -1, 'L'},
            {0, 1, 'R'}
    };

    public static void main(String... args) {
        int[][] A
                = { { 0, -1, 0 },
                    { 0, 0, 0 },
                    { 0, 0, 0 } };

        bfs(A);
        List<String> paths = new ArrayList<>();
        int[][] B
                = { { 0, -1, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 } };
        dfs(B, 0, 0, new StringBuilder(), paths);
        System.out.println("DFS " + paths);
    }





    private static void dfs(int[][] grid, int x, int y, StringBuilder aux, List<String> paths) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            paths.add(aux.toString());
            return;
        }

        grid[x][y] = -1;

        for (int dir[] : direction) {
            int row = x + dir[0];
            int col = y + dir[1];
            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length &&
                grid[row][col] == 0) {
                aux.append((char) dir[2]);
                dfs(grid, row, col, aux, paths);
                aux.deleteCharAt(aux.length() - 1);
            }
        }

        grid[x][y] = 0;
    }

    private static void bfs(int[][] grid) {
        Queue<int[]> level = new ArrayDeque<>();
        Queue<StringBuilder> paths = new ArrayDeque<>();
        paths.add(new StringBuilder());
        level.add(new int[] {0,  0});
        List<String> ans = new ArrayList<>();
        grid[0][0] = -1;
        while (!level.isEmpty()) {
            int size = level.size();
            while (size -- > 0) {
                StringBuilder step = paths.poll();
                int row = level.peek()[0];
                int col = level.poll()[1];
                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    ans.add(step.toString());
                    continue;
                }

                for (int[] dir : direction) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
                            grid[x][y] == 0) {
                        grid[x][y] = -1;
                        paths.add(new StringBuilder(step).append((char) dir[2]));
                        level.add(new int[]{x, y});
                        if (x == grid.length - 1 && y == grid[0].length - 1) {
                            grid[x][y] = 0;
                        }
                    }
                }
            }
        }

        System.out.println("BFS " + ans);
    }
}
