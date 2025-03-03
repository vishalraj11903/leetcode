package practice;

import java.util.*;

public class CakeCutting {
    public static boolean canCutCake(int[] cake, int n) {
        int totalStrawberries = Arrays.stream(cake).sum();
        int pieces = n + 1;

        // Check if total strawberries can be evenly divided into n + 1 pieces
        if (totalStrawberries % pieces != 0) {
            return false;
        }

        int target = totalStrawberries / pieces;
        int currentSum = 0;
        int count = 0;

        // Try to form pieces with the target sum
        for (int strawberries : cake) {
            currentSum += strawberries;
            if (currentSum == target) {
                count++;
                currentSum = 0; // Reset for the next piece
            } else if (currentSum > target) {
                return false; // Exceeds target, invalid division
            }
        }

        // Check if we formed exactly n + 1 pieces
        return count == pieces;
    }

    public static void main(String[] args) {
        int[] cake1 = {1, 2, 3};
        System.out.println(canCutCake(cake1, 1)); // True
        System.out.println(canCutCake(cake1, 2)); // False

        int[] cake2 = {2, 2, 2, 2};
        System.out.println(canCutCake(cake2, 3)); // True
    }
}
