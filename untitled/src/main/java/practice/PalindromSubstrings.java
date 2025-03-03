package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time: O(N^2)
 * Space: O(1)
 */
public class PalindromSubstrings {
    public static void main(String... args) {
        String input = "abbac";
        Set<String> output = new HashSet<>();

        for (int i = 0; i < input.length(); ++i) {
            findPalin(input, i, i, output);      // Odd-length palindromes
            findPalin(input, i, i + 1, output);  // Even-length palindromes
        }

        System.out.println(output);
    }

    static void findPalin(String input, int left, int right, Set<String> output) {
         while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
             output.add(input.substring(left, right + 1));
             left--;
             right++;
         }
    }
}
