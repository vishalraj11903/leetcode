package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalSolution {
    public static void intervalSolution(int[][] intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        // Separate starts and ends
        for (int[] interval : intervals) {
            starts.add(interval[0]);
            ends.add(interval[1]);
        }

        // Sort starts and ends
        Collections.sort(starts);
        Collections.sort(ends);

        int maxFreq = 0, curFreq = 0, sPtr = 0, ePtr = 0;
        int maxNum = 0;

        // Find the maximum frequency
        while (sPtr < starts.size() && ePtr < ends.size()) {
            if (starts.get(sPtr) <= ends.get(ePtr)) {
                curFreq++;
                if (curFreq > maxFreq) {
                    maxFreq = curFreq;
                    maxNum = starts.get(sPtr);
                }
                sPtr++;
            } else {
                curFreq--;
                ePtr++;
            }
        }

        System.out.println("Number " + maxNum + " occurred " + maxFreq + " times");
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {-1, 5},
                {-2, 6},
                {-3, 7},
                {-4, 8}
        };
        intervalSolution(intervals);
    }
}
