package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Nam {
    public static void main(String... args) {
        System.out.println(getSeq(new String[][] {
                {"abcee", "acdeedb"}/*,
                {"sljffsaje", "sljsje"},
                {"safddadfs", "famafmss"},
                {"a", "b"},
                {"a", "bc"},*/
        }));
    }

    static List<Boolean> getSeq(String[][] inputs) {
        List<Boolean> result = new ArrayList<>();
        for (String[] input : inputs) {
            boolean isAna = second(input);
            result.add(isAna);
        }

        return result;
    }

    static boolean second(String[] input) {
        String first = input[0];
        String second = input[1];
        char[] chFirst = new char[26];
        char[] chSecond = new char[26];
        for (int i = 0; i < first.length(); ++i) {
            chFirst[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); ++i) {
            chSecond[second.charAt(i) - 'a']++;
        }

        int backFirst = String.valueOf(chFirst).hashCode();
        int backSecond = String.valueOf(chSecond).hashCode();

        return backSecond == backFirst;
    }

    static boolean getAna(String[] input) {
        String first = input[0];
        String second = input[1];
        TreeSet<Character> firstSet = new TreeSet<>();
        TreeSet<Character> secondSet = new TreeSet<>();
        for (char ch : first.toCharArray()) {
            firstSet.add(ch);
        }
        for (char ch : second.toCharArray()) {
            secondSet.add(ch);
        }

        StringBuilder removedDupsFirst = new StringBuilder();
        StringBuilder removedDupsSecond = new StringBuilder();

        for (char ch : firstSet) {
            removedDupsFirst.append(ch);
        }

        for (char ch : secondSet) {
            removedDupsSecond.append(ch);
        }
        int firstPointer = 0, secondPointer = 0;
        if (removedDupsFirst.equals(removedDupsSecond)) {
            return true;
        } else if (Math.abs(removedDupsFirst.length() - removedDupsSecond.length()) > 1) {
            return false;
        } else {

            while (firstPointer < removedDupsFirst.length() && secondPointer < removedDupsSecond.length()) {
                char ch1 = removedDupsFirst.charAt(firstPointer);
                char ch2 = removedDupsSecond.charAt(secondPointer);
                if (ch1 < ch2) {
                    firstPointer++;
                } else if (ch1 > ch2) {
                    secondPointer++;
                } else if (ch1 == ch2){
                    firstPointer++;
                    secondPointer++;
                }
            }
        }

        return firstPointer > 0 && secondPointer > 0 ? Math.abs(firstPointer - secondPointer) <= 1 : false;
    }
}
