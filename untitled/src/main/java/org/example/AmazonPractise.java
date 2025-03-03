package org.example;

import java.util.Arrays;

public class AmazonPractise {
    public static void main(String... args) {
        int[] input = {1,0,3,2,2,1,1,0,4,5};
        int[] count = new int[6];
        Arrays.fill(count, - 1);
        for (int val : input) {
            if (count[val] == -1) {
                count[val] = 0;
            }
            count[val]++;
        }

        int[] output = new int[input.length];
        int index = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] != -1) {
                populateData(output, count, i, index);
                index += count[i];
            }
        }

        for (int i : output) {
            System.out.print(i + " ");
        }
    }

    private static void populateData(int[] output, int[] count, int i, int index) {
        int size = count[i];
        while (size-- > 0) {
            output[index++] = i;
        }
    }


}
