package org.example;

import java.util.HashSet;
import java.util.Set;

public class Cycles {
    public static void main(String... args) {
        int[] input = {3, 0, 1, 2, 4, 6, 5};
        // int[] input = {0, 1, 2};
        int cycles = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] != -1) {
                count(input, i);
                cycles++;
            }
        }

        System.out.println(cycles);
    }

    private static void count(int[] input, int i) {
        int index = i;
        while (input[index] != -1) {
            int prev = index;
            index = input[index];
            input[prev] = - 1;
        }
    }
}
