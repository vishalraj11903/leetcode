package practice;

import java.util.Arrays;

public class SortNColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 3, 3, 1};
        int n = 4;

        SortNColors sorter = new SortNColors();
        sorter.sortColors(nums, n);
        System.out.println(Arrays.toString(nums));
    }

    private void sortColors(int[] nums, int n) {
         int[] colors = new int[n];
         for (int num : nums) {
             colors[num]++;
         }

         int index = 0;
         for (int i = 0; i < colors.length; ++i) {
             int count = colors[i];
             while (count-- > 0) {
                 nums[index++] = i;
             }
         }


    }
}
