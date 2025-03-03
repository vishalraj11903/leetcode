package practice;
import java.util.*;

public class ShortestPathBinaryMatrix2 {
    int[][] directions = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1},   // Up, Left, Down, Right
            {-1, 1}, {1, -1}, {1, 1}, {-1, -1} // Diagonal movements
    };
    String[] symbols = {"Left", "Up", "Down", "Right",
            "TopRight", "BottomLeft", "BottomRight", "TopLeft"};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        Map<String, String> map = new HashMap<>();
        Map<String, String> pits = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int x1 = current[0];
                int y1 = current[1];
                if (x1 == grid.length - 1 && y1 == grid[0].length - 1) {
                    return getPath(grid, map, pits);
                }
                for (int i = 0; i < symbols.length; ++i) {
                    int x = directions[i][0] + x1;
                    int y = directions[i][1] + y1;
                    if (x >= 0 && y >= 0 && x < grid.length
                            && y < grid[0].length && grid[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[] {x, y});
                        pits.put(x + "-" + y, symbols[i]);
                        map.put(x + "-" + y , x1 + "-" + y1);
                    }
                }
            }
        }

        return -1;
    }

    int getPath(int[][] grid, Map<String, String> map,  Map<String, String> pits) {
        String key = (grid.length - 1) + "-" + (grid[0].length - 1);
        List<String> path = new ArrayList<>();

        while (map.containsKey(key)) {
            // path.add(key);
            path.add(pits.get(key));
            key = map.get(key);
        }
        // path.add("0-0"); // Add the start point
        path.add("start");
        Collections.reverse(path);
        System.out.println("Path: " + String.join(" -> ", path));
        return path.size();
    }
}
