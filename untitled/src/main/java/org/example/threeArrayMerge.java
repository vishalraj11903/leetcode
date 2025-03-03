package org.example;

import java.util.ArrayList;
import java.util.List;

public class threeArrayMerge {
    public static void main(String... args) {
        int[] arr1 = {2,2,2,2,4};
        int[] arr2 = {1,2,3};
        int[] arr3 = {3,3,3,4,4};
        int first = 0, second = 0, third = 0;
        List<Integer> result = new ArrayList<>();
        while (first < arr1.length && second < arr2.length && third < arr3.length) {
            int min = Math.min(arr1[first], Math.min(arr2[second], arr3[third]));
            first = increamentForward(arr1, first, min);
            second = increamentForward(arr2, second, min);
            third = increamentForward(arr3, third, min);

            result.add(min);
        }
       // residue(arr1, first, result);
       // residue(arr2, second, result);
       // residue(arr3, third, result);

        System.out.println(result);
    }

    static int increamentForward(int[] arr, int counter, int min) {
        while (counter < arr.length && min == arr[counter]) {
            counter++;
        }
        return counter;
    }

    static  void residue(int[] arr, int counter, List<Integer> result) {
        while (counter < arr.length) {
            if (result.getLast() != arr[counter]) {
                result.add(arr[counter]);
            }
            counter++;
        }
    }
}
