package practice;

import java.util.Arrays;

public class MaxSumOfThreeIntervals {
    public static int maxSumOfThreeIntervals(int[] arr, int k) {
        int n = arr.length;
        if (n < 3 * k) {
            return 0; // Not enough elements for three non-overlapping intervals
        }

        // Step 1: Compute k-sum array
        int[] kSum = new int[n - k + 1];
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        kSum[0] = currentSum;

        for (int i = 1; i < kSum.length; i++) {
            currentSum = currentSum - arr[i - 1] + arr[i + k - 1];
            kSum[i] = currentSum;
        }
        // Step 2: Compute leftBest array
        int[] leftBest = new int[kSum.length];
        int bestIndex = 0;

        for (int i = 0; i < kSum.length; i++) {
            if (kSum[i] > kSum[bestIndex]) {
                bestIndex = i;
            }
            leftBest[i] = bestIndex;
        }

        // Step 3: Compute rightBest array
        int[] rightBest = new int[kSum.length];
        bestIndex = kSum.length - 1;

        for (int i = kSum.length - 1; i >= 0; i--) {
            if (kSum[i] >= kSum[bestIndex]) {
                bestIndex = i;
            }
            rightBest[i] = bestIndex;
        }

        // Step 4: Find the maximum sum of three intervals
        int maxSum = 0;

        for (int mid = k; mid < kSum.length - k; mid++) {
            int left = leftBest[mid - k];
            int right = rightBest[mid + k];
            int totalSum = kSum[left] + kSum[mid] + kSum[right];
            maxSum = Math.max(maxSum, totalSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 3, 4, 7, 5, 2, 5, 9};
        int k = 2;
        System.out.println(maxSumOfThreeIntervals(arr, k)); // Output: 39
    }
}
