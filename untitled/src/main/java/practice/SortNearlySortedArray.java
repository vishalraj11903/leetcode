package practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
    //Expected Approach – Using Heap – O(k + (n-k)*Log k) Time and O(k) Space
    public static void main(String... args) {
        int[] input = {6, 5, 3, 2, 8, 10, 9};
        int size = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = Math.min(input.length, size + 1);
        for (int i = 0; i < min; ++i) {
            pq.add(input[i]);
        }

        int index = 0;

        for (int i = size + 1; i < input.length; ++i) {
            input[index++] = pq.poll();
            pq.add(input[i]);
        }

        Iterator<Integer> itr = pq.iterator();

        while (itr.hasNext()) {
            input[index++] = pq.peek();
            pq.poll();
        }

        Arrays.stream(input).forEach(num -> System.out.println(num));
    }
}
