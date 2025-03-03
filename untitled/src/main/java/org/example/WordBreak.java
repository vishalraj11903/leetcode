package org.example;

import java.util.*;

public class WordBreak {

    static String wordBreak(String word, List<String> dictionary) {

        StringBuilder result = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            result.append(word.charAt(i));
            if (dictionary.contains(result.toString())) {
                ans.append(result.toString()).append(" ");
                result = new StringBuilder();
            }
        }

        return ans.toString();
    }

    static int missingNumber(int[] input) {
        int left = 0, right = input.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid < input.length - 1) {
                if (input[mid + 1] - input[mid] > 1) {
                    return input[mid] + 1;
                }
                right = mid - 1;
            } else {
                if (mid > 0 && input[mid] - input[mid - 1] > 1) {
                    return input[mid - 1] + 1;
                }
                left = mid + 1;
            }
        }
        
        return -1;
    }

    public static void merge(int[][] interval1, int[][] interval2) {
        List<int[]> list = new ArrayList<>();
        int first = 0, second = 0;
        while (first < interval1.length && second < interval2.length) {
            if (interval1[first][0] <= interval2[second][0]) {
                if (theyOverLap(interval1, first, interval2, second)) {
                    list.add(merge1(interval1[first], interval2[second]));
                    first++;
                    second++;
                } else {
                    list.add(interval1[first]);
                    first++;
                }
            } else {
                if (theyOverLap(interval2, second, interval1, first)) {
                    list.add(merge1(interval2[second], interval1[first]));
                    first++;
                    second++;
                } else {
                    list.add(interval2[second]);
                    second++;
                }
            }
        }

        while (first < interval1.length) {
            list.add(interval1[first++]);
        }

        while (second < interval2.length) {
            list.add(interval2[second++]);
        }

        LinkedList<int[]> compress = new LinkedList<>();
        for (int[] val : list) {
            if (!compress.isEmpty() && compress.getLast()[1] >= val[0]) {
                compress.getLast()[1] = val[1];
            } else {
                compress.add(val);
            }
        }

        for (int[] c : compress) {
            System.out.println(c[0] + "," + c[1]);
        }
    }

    private static int[] merge1(int[] ints, int[] ints1) {
        int[] val = new int[2];
        val[0] = Math.min(ints[0], ints1[0]);
        val[1] = Math.max(ints[1], ints1[1]);
        return val;
    }

    private static boolean theyOverLap(int[][] interval1, int first, int[][] interval2, int second) {
        return interval1[first][1] >= interval2[second][0];
    }

    public static void main(String... args) {
        /*String input = "theskyisblue" ;
        List<String> list = Arrays.asList("the", "sky", "is", "sd");
        System.out.println(wordBreak(input, list));*/
       // int[] input = {2,3,5,6,7,8,9,10,11,12,13,14,15};
       // System.out.println(missingNumber(input));
        int[][] interval1 = {{1, 2}, {3, 9}};
        int[][] interval2 = {{4, 6}, {8, 10}, {11 ,12}};
        merge(interval1, interval2);
    }
}
