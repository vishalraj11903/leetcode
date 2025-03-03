package practice;

import java.util.ArrayList;
import java.util.List;

public class MergeThreeSortedArrays {
    public static void main(String... args) {
        int[] a = {2,2,3,4};
        int[] b =  {3,4,5};
        int[] c = {4, 5, 6};
        List<Integer> list = new ArrayList<>();
        int first = 0, second = 0, third = 0;
        while (first  < a.length || second < b.length || third < c.length) {
            int one = first < a.length ? a[first] : Integer.MAX_VALUE;
            int two = second < b.length ? b[second] : Integer.MAX_VALUE;
            int three =  third < c.length ? c[third] : Integer.MAX_VALUE;
            int min = Math.min(one, Math.min(two, three));
            while (first < a.length && a[first] == min) {
                first++;
            }
            while (second < b.length && b[second] == min) {
                second++;
            }
            while (third < c.length && c[third] == min) {
                third++;
            }

            list.add(min);
        }

        System.out.println(list);
    }
}
