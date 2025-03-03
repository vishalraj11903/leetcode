package practice;
import java.util.Arrays;

public class FlightMinCost {
    public static int findMinTotalCost(int[] depart, int[] arrival) {
        if (depart == null || arrival == null || depart.length != arrival.length || depart.length < 2) {
            throw new IllegalArgumentException("Invalid input: Arrays must be non-null, of the same length, and have at least two elements.");
        }

        int minTotalCost = Integer.MAX_VALUE;
        int minDepart = Integer.MAX_VALUE;

        for (int i = 0; i < depart.length - 1; ++i) {
            minDepart = Math.min(minDepart, depart[i]);
            minTotalCost = Math.min(minTotalCost, minDepart + arrival[i + 1]);
        }

        return minTotalCost;
    }


    public static void main(String[] args) {
        // Test Case 1: Regular input
        int[] depart1 = {1, 2, 3, 4};
        int[] arrival1 = {4, 3, 2, 1};
        System.out.println("Test Case 1: " + testFindMinTotalCost(depart1, arrival1, 3)); // Expected: 3

        // Test Case 2: All costs are the same
        int[] depart2 = {5, 5, 5, 5};
        int[] arrival2 = {5, 5, 5, 5};
        System.out.println("Test Case 2: " + testFindMinTotalCost(depart2, arrival2, 10)); // Expected: 10

        // Test Case 3: Costs in descending order
        int[] depart3 = {10, 9, 8, 7};
        int[] arrival3 = {10, 9, 8, 7};
        System.out.println("Test Case 3: " + testFindMinTotalCost(depart3, arrival3, 15)); // Expected: 15

        // Test Case 4: Costs in ascending order
        int[] depart4 = {1, 2, 3, 4};
        int[] arrival4 = {1, 2, 3, 4};
        System.out.println("Test Case 4: " + testFindMinTotalCost(depart4, arrival4, 3)); // Expected: 3

        // Test Case 5: Edge case with only two elements
        int[] depart5 = {10, 20};
        int[] arrival5 = {30, 40};
        System.out.println("Test Case 5: " + testFindMinTotalCost(depart5, arrival5, 50)); // Expected: 50

        // Test Case 6: Large numbers
        int[] depart6 = {1000, 2000, 3000};
        int[] arrival6 = {3000, 2000, 1000};
        System.out.println("Test Case 6: " + testFindMinTotalCost(depart6, arrival6, 3000)); // Expected: 3000

        // Test Case 7: Invalid input (different lengths)
        int[] depart7 = {1, 2, 3};
        int[] arrival7 = {4, 5};
        try {
            System.out.println("Test Case 7: " + testFindMinTotalCost(depart7, arrival7, -1));
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 7: Passed with exception - " + e.getMessage());
        }

        // Test Case 8: Invalid input (less than two elements)
        int[] depart8 = {5};
        int[] arrival8 = {10};
        try {
            System.out.println("Test Case 8: " + testFindMinTotalCost(depart8, arrival8, -1));
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 8: Passed with exception - " + e.getMessage());
        }
    }

    /**
     * Helper function to test the findMinTotalCost function.
     * @param depart Departure costs array.
     * @param arrival Arrival costs array.
     * @param expected The expected result.
     * @return "Passed" if the result matches the expected value, otherwise "Failed".
     */
    private static String testFindMinTotalCost(int[] depart, int[] arrival, int expected) {
        try {
            int result = findMinTotalCost(depart, arrival);
            return result == expected ? "Passed" : "Failed (Expected: " + expected + ", Got: " + result + ")";
        } catch (IllegalArgumentException e) {
            return "Failed with exception: " + e.getMessage();
        }
    }
}
