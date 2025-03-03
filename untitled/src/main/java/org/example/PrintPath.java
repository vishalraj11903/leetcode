package org.example;

import java.util.*;

public class PrintPath {
    public static void main(String... args) {
        int[][] directions = { {-1, 0, 'L'}, {1, 0, 'R'}, {0, -1, 'U'}, {0, 1, 'D'}};
        int[][] grid = {
                {0,0,0},
                {0,0,0},
                {1,1,0}
        };

       Queue<int[]> queue = new ArrayDeque<>();
       Map<String, String> map = new HashMap<>();
       queue.add(new int[] {0, 0});
       while (!queue.isEmpty()) {
           int size = queue.size();
           while(size-- > 0) {
               int[] current = queue.poll();
               if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1) {
                  // map.put(current[0] + "," + current[1])
                   break;
               }
               grid[current[0]][current[1]] = 1;

               for (int[] direction : directions) {
                   int row = current[0] + direction[0];
                   int col = current[1] + direction[1];
                   if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 0) {
                       queue.add(new int[] {row, col});
                       map.put(row + "," + col, current[0] + "," + current[1] + "," + (char) direction[2]);
                   }
               }
           }
       }
        System.out.println(map);

        List<String> paths = new ArrayList<>();
        String finalD = "2,2";
        while (map.containsKey(finalD)) {
            finalD = map.get(finalD);
            String[] values = finalD.split(",");
            paths.add(values[2]);
            finalD = values[0]+","+values[1];

        }
        // Collections.reverse(paths);
        System.out.println(paths);

    }
}
