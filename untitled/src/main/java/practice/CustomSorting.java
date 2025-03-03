package practice;

import java.util.HashMap;
import java.util.Map;

public class CustomSorting {
    public static void main(String... args) {
        String order = "cba", s = "abcd";
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            if (sMap.containsKey(ch)) {
                int count = sMap.get(ch);
                while (count-- > 0) {
                    output.append(ch);
                }
                sMap.remove(ch);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                output.append(entry.getKey());
            }
        }

        System.out.println(output);
    }
}
