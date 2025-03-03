package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interval {
    public static void main(String... args) {
        int[][] interval1 = {{1,5}, {10, 14}, {16, 18}};
        int[][] interval2 = {{2,6}, {14, 10}, {11, 20}};
        int first = 0, second = 0;
        LinkedList<int[]> result = new LinkedList<>();
        while (first < interval1.length && second < interval2.length) {
            int[] firstI = null;
            int[] secondI = null;

            if (interval1[first][0] < interval2[second][0]) {
                firstI = interval1[first];
                secondI = interval2[second];
            } else {
                firstI = interval2[second];
                secondI = interval1[first];
            }
            if (firstI[1] >= secondI[0]) {
                int min = Math.min(firstI[0], secondI[0]);
                int max = Math.max(firstI[1], secondI[1]);
                result.add(new int[] {min, max});
                first++;
                second++;
            } else {
                result.add(firstI);
                if (firstI == interval1[first]) {
                    first++;
                } else {
                    second++;
                }
            }
        }

       for (int i = 1; i < result.size(); ++i) {
           if (result.get(i - 1)[1] >= result.get(i)[0]) {
               result.get(i - 1)[1] = result.get(i)[1];
               result.remove(i);
           }
       }

       for (int[] value : result) {
           System.out.println(value[0] + " - " + value[1]);
       }
    }
}
