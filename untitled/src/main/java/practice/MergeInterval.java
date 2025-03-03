package practice;

import java.util.LinkedList;
import java.util.Stack;

public class MergeInterval {
    public static void main(String... args) {
        int[][] interval1 = new int[][] {{1, 5}, {10, 14}, {16, 18}};
        int[][] interval2 = new int[][] {{2, 6}, {8, 10}, {11, 20}};

        int first = 0, second = 0;
        LinkedList<int[]> list = new LinkedList<>();
        while (first < interval1.length && second < interval2.length) {
            if (interval1[first][0] < interval2[second][0]) {
                addOrUpdate(list, interval1[first]);
                first++;
            } else {
                addOrUpdate(list, interval2[second]);
                second++;
            }
        }

        while (first < interval1.length) {
            addOrUpdate(list, interval1[first]);
            first++;
        }

        while (second < interval2.length) {
            addOrUpdate(list, interval2[second]);
            second++;
        }

        for (int[] val : list) {
            System.out.println(val[0] + "," + val[1]);
        }
        System.out.println(list);
    }

    static void addOrUpdate(LinkedList<int[]> list, int[] interval) {
        if (!list.isEmpty() && list.getLast()[1] >= interval[0]) {
            list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
        } else {
            list.add(interval);
        }
    }
}
