package practice;

import java.util.Arrays;
import java.util.Collections;

public class SecondHighest {
    public static void main(String... args) {
        int input = 516611234;
        String str = String.valueOf(input);
        Integer[] arr = new Integer[str.length()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = str.charAt(i) - '0';
        }
        Arrays.sort(arr, Collections.reverseOrder());

        /**
         *    2,3,1,2,3
         *    2,2,1,3,3
         *    2,,2,1,3,3
         */

        int left = arr.length - 2;
        while (left >= 0 && arr[left] <= arr[left + 1]) {
            left--;
        }

        if (left >= 0) {
            int right = arr.length - 1;
            while (right >= 0 && arr[right] <= arr[left]) {
                right--;
            }
            swap(arr, left, right);
        }

        reverse(arr, left + 1);

        System.out.println(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    static void swap(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static void reverse(Integer[] arr, int left) {
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
