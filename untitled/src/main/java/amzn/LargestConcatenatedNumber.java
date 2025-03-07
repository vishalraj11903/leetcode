package amzn;

import java.util.*;

public class LargestConcatenatedNumber {
    public static String largestNumber(int[] nums) {
        // Convert integers to strings for custom sorting
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Custom comparator: Sort in descending order based on concatenation
        Arrays.sort(strNums, (b, a) -> (a + b).compareTo(b + a));

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) return "0";

        // Join sorted numbers to form the final largest number
        return String.join("", strNums);
    }

    public static void main(String[] args) {
        int[] input = {8, 93, 24, 6};
        System.out.println(largestNumber(input));  // Output: 993624
    }
}
