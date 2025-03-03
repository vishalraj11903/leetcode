package practice;

import java.util.Random;

public class MaximumRandom {
    public static void main(String... args) {
        int[] input = {11, 30, 2, 30, 30, 30, 6, 2, 62, 62};
        //int[] input = {1,2, 1};

        int maxIndex = -1, max = Integer.MIN_VALUE;
        int count = 1;

        for (int i = 0; i < input.length; ++i) {
            if (max < input[i]) {
                max = input[i];
                maxIndex = i;
                count = 1;
            } else if (max == input[i]) {
                count++;
                if (new Random().nextInt(count) == 0) {
                    maxIndex = i;
                }
            }
        }


       /* Random random = new Random();

        for (int i = 0; i < input.length; ++i) {
            if (input[i] > max) {
                max = input[i];
                maxIndex = i;
                count = 1; // Reset count for the new max
            } else if (input[i] == max) {
                count++;
                // Randomly decide whether to update maxIndex
                if (random.nextInt(count) == 0) {
                    maxIndex = i;
                }
            }
        }*/

        System.out.println("Randomly selected index of max value: " + maxIndex);
        System.out.println("Value at selected index: " + input[maxIndex]);




        /*int maxIndex = -1, max = Integer.MIN_VALUE;
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < input.length; ++i) {
            if (input[i] > max) {
                max = input[i];
                count = 1;
                maxIndex = i;
            } else if (input[i] == max) {
                count++;

                if (random.nextInt(count) == 0) {
                    maxIndex = i;
                }
            }
        }
*/
     //   System.out.println(maxIndex);
    }
}
