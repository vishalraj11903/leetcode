package org.example;

import java.util.*;

public class Onsite {

    static void secondHighest(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);


        secondHighest(root.left, level + 1, map);
        secondHighest(root.right, level + 1, map);
    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int minFood(TreeNode root, int level) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.food) {
            return root.val;
        }

        int left = minFood(root.left, level + 1);
        int right = minFood(root.right, level + 1);
        return Math.min(left, right);
    }

    static void subSeq(int[] input, int target) {
        int left = 0, right = 0;
        int total = 0;
        while (right < input.length) {
            total += input[right];
            while (left < right && total > target) {
                total -= input[left];
                left++;
            }

            if (total == target) {
                System.out.println("Got the target");
            }

            right++;
        }
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void grid() {
        char[][] grid = new char[][] {
                {'_', 'W', 'G', '_'},
                {'_', '_','_', 'W'},
                {'_', 'W','_', 'W'},
                {'G', 'W','_', '_'},
        };


        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 'G') {
                    bfs(grid, i, j);
                }
            }
        }

        // Print the grid
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static void bfs(char[][] grid, int row, int col) {
       int step = 0;
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[] {row, col});
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       while (!queue.isEmpty()) {
           int size = queue.size();
           while(size-- > 0) {
               int[] current = queue.poll();
               int r = current[0];
               int c = current[1];
               if (grid[r][c] == '_' || (Character.isDigit(grid[r][c]) && step < Integer.valueOf(grid[r][c] + "").intValue())) {
                   grid[r][c] = (step + "").toCharArray()[0];
               }

               for (int[] dir : directions) {
                   int newRow = r + dir[0];
                   int newCol = c + dir[1];
                   if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                       if (grid[newRow][newCol] != 'W' && !visited[newRow][newCol]) {
                           visited[newRow][newCol] = true;
                           queue.add(new int[] {newRow, newCol});
                       }
                   }
               }
           }
           step++;
       }
    }

    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        rootRight.food = true;
        TreeNode twoLeft = new TreeNode(4);
        twoLeft.food = true;
        TreeNode twoRight = new TreeNode(5);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(rootLeft);
        list.add(rootRight);
        list.add(twoLeft);
        list.add(twoRight);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = twoLeft;
        rootRight.right = twoRight;

        // System.out.println(getRoot(list).val);
        Map<Integer, List<Integer>> map = new HashMap<>();
        secondHighest(root, 0, map);
        int val = height(root) - 1;
        if (map.containsKey(val - 1)) {
            System.out.println(map.get(val - 1));
        }

        subSeq(new int[] {1, 3, 5, 98}, 8);
        System.out.println(minFood(root, 0));

        grid();
    }
}
