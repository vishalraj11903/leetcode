package practice;

import java.util.*;

public class AverageStream {
    public static List<Integer> computeRunningSumVariant(int[] nums, int size) {
        List<Integer> result = new ArrayList<>();
       /* int windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right]; // Add current element to the window sum

            int left = right - size;
            if (left >= 0) {
                windowSum -= nums[left]; // Remove the element that's out of the window
            }

            if (right >= size - 1) {
                result.add(windowSum / size); // Calculate and add the average to the result
            }
        }*/

        int left = 0, right = 0, sum = 0;
       // while (right < size) {
       //     sum += nums[right++];
      //  }

       // result.add(sum / size);
        while (right < nums.length) {
            if (right >= size) {
                sum -= nums[left++];
            }
            sum += nums[right++];
            if (right >= size) {
                result.add(sum / size);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {5, 2, 8, 14, 3};
        int size1 = 3;
        System.out.println(computeRunningSumVariant(nums1, size1)); // Output: [5, 8, 8]

        int[] nums2 = {6};
        int size2 = 1;
        System.out.println(computeRunningSumVariant(nums2, size2)); // Output: [6]

        int[] nums3 = {1, 2, 3};
        int size3 = 1;
        System.out.println(computeRunningSumVariant(nums3, size3)); // Output: [1, 2, 3]

        int[] nums4 = {2, 4, 6, 8, 10, 12};
        int size4 = 2;
        System.out.println(computeRunningSumVariant(nums4, size4)); // Output: [3, 5, 7, 9, 11]

        int[] nums5 = {1, 2, 3, 4, 5};
        int size5 = 4;
        System.out.println(computeRunningSumVariant(nums5, size5)); // Output: [2, 3]

        int[] nums6 = {1, 2, 1, 2};
        int size6 = 2;
        System.out.println(computeRunningSumVariant(nums6, size6)); // Output: [1, 1, 1]
    }
}
