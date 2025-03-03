package practice;
import java.util.*;

public class WordBreak {
    /**
     * Time complexity:
     * In the worst case:
     *
     * At each of the
     * n: Length of the input string
     * K: Number of words in hashMap
     * L: Maximum length of a word in the HashMap
     * O(k⋅L⋅n)
     * @param args
     */
    public static void main(String...args) {
        // Example 1
        Map<String, Integer> map1 = Map.of("abc", 3, "ab", 2, "abca", 1);
        System.out.println("canBreakString " +canBreakString("abcabcabcabca", new java.util.HashMap<>(map1))); // true
        System.out.println("practice " + practice("abcabcabcabca", new java.util.HashMap<>(map1))); // true

        // Example 2
        Map<String, Integer> map2 = Map.of("abc", 3, "ab", 2);
        System.out.println("canBreakString " + canBreakString("abcabab", new java.util.HashMap<>(map2))); // true
        System.out.println("practice " + practice("abcabab", new java.util.HashMap<>(map2))); // true

        // Example 3
        Map<String, Integer> map3 = Map.of("abc", 3, "ab", 2, "abca", 1);
        System.out.println("canBreakString " +canBreakString("abcx", new java.util.HashMap<>(map3))); // false
        System.out.println("practice " + practice("abcx", new java.util.HashMap<>(map3))); // false

    }

    private static boolean backtrack(String s, Map<String, Integer> wordFreq) {
        if (s.length() == 0) {
            return true;
        }

        for (String word : wordFreq.keySet()) {
            int freq = wordFreq.get(word);
            if (freq > 0 && s.startsWith(word)) {
                wordFreq.put(word, freq - 1);
                if (backtrack(s.substring(word.length()), wordFreq)) {
                    return true;
                }
                wordFreq.put(word, freq);
            }
        }

        return false;
    }

    static boolean practice(String s, Map<String, Integer> wordFreq) {
        if (s.length() == 0) {
            return true;
        }

        for (String word : wordFreq.keySet()) {

            if (s.startsWith(word) && wordFreq.get(word) > 0) {
                wordFreq.put(word, wordFreq.get(word) - 1);
                if (practice(s.substring(word.length()), wordFreq)) {
                    return true;
                }
                wordFreq.put(word, wordFreq.get(word) + 1);
            }
        }

        return false;
    }



    public static boolean canBreakString(String s, Map<String, Integer> wordFreq) {
        return backtrack(s, wordFreq);
    }


}
