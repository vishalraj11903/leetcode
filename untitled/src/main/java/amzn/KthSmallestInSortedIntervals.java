package amzn;

import java.util.*;

public class KthSmallestInSortedIntervals {
    static class Interval {
        int start, end;
        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static int findKthSmallest(int k, List<Interval> intervals) {
        int n = intervals.size();
        int[] prefixSum = new int[n];

        // Step 1: Compute prefix sum of counts
        prefixSum[0] = intervals.get(0).end - intervals.get(0).start + 1;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (intervals.get(i).end - intervals.get(i).start + 1);
        }

        // Step 2: Binary search for the correct interval
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Step 3: Calculate the exact number within the found interval
        int prevCount = left > 0 ? prefixSum[left - 1] : 0;
        int positionInInterval = k - prevCount;
        return intervals.get(left).start + positionInInterval - 1;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(5, 10),  // 5, 6, 7, 8, 9, 10 (6 numbers)
                new Interval(15, 20), // 15, 16, 17, 18, 19, 20 (6 numbers)
                new Interval(25, 40), // 25 to 40 (16 numbers)
                new Interval(50, 100) // 50 to 100 (51 numbers)
        );

        System.out.println(findKthSmallest(1, intervals));  // Output: 5
        System.out.println(findKthSmallest(6, intervals));  // Output: 10
        System.out.println(findKthSmallest(7, intervals));  // Output: 15
        System.out.println(findKthSmallest(20, intervals)); // Output: 34
    }
}
