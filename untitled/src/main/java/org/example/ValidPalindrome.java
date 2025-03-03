package org.example;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class ValidPalindrome {

    public static void main(String... args) {
        String input = "abba";
        Set<String> result = new HashSet<>();
        for (int i = 0; i < input.length(); ++i) {
            findPalindrome(input, i, i, result);
            findPalindrome(input, i, i + 1, result);
        }
        System.out.println(result);
    }

    static void findPalindrome(String input, int left, int right, Set<String> set) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            set.add(input.substring(left, right + 1));
            left--;
            right++;
        }
    }

}
