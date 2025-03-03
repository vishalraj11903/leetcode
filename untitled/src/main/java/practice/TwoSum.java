package practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String... args) {
        int[][] input = {
                {1, 9},
                {3, 7},
                {5, 5},
                {7, 3},
                {9, 1}
        };

        int k = 10;
        Map<String, int[]> map = new HashMap<>();
        for (int[] values : input) {
            int x = values[0];
            int y = values[1];
            String key = x + "-" + y;
            if (map.containsKey(key)) {
                System.out.println("Ans");
                System.out.print(map.get(key)[0] + "-" + map.get(key)[1] + "," + x + "-" + y);
                break;
            }
            int x1 = k - x;
            int y1 = k - y;
            key = x1 + "-" + y1;
            map.put(key, new int[] {x, y});
        }
    }
}
