package org.example;

import java.util.Random;

public class RandomMaxIndex {
    public static void main(String... args) {
      int[] nums = {11, 30, 2, 30, 30, 30, 6, 2, 62, 1};
      Random random = new Random();
      int index = 0, max = Integer.MIN_VALUE, count = 0;
      for (int i = 0; i < nums.length; ++i) {
          if (max < nums[i]) {
              count = 1;
              index = i;
              max = nums[i];
          } else if (max == nums[i]) {
              count++;
              if (random.nextInt(count) == 0) {
                  index = i;
              }
          }
      }

        System.out.println("Index " + index);
    }
}
