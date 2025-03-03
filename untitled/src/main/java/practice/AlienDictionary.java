package practice;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    public static void main(String... args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello","leetcode"};
        Map<Character,Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                System.out.println("False");
                break;
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (orderMap.get(word1.charAt(j)) > orderMap.get(word2.charAt(j + 1))) {
                        System.out.println("False");
                    }
                    break;
                }
            }

        }
    }
}
