package practice;

public class SumDistinct {
    public static void main(String[] args) {
        int[] inputArray = {1,1};
        int result = sumOfDistinct(inputArray);
        System.out.println("Sum of distinct characters: " + result);
    }

    /**
     * Returns the sum of distinct characters in the given input.
     *
     * @param nums an array of integers
     * @return the sum of distinct characters
     */
    public static int sumOfDistinct(int[] nums) {
        int bitmask = 0;

        // Initialize a variable to store the sum
        int totalSum = 0;

        // Iterate over the input array
        for (int num : nums) {
            // Check if the number is already in the bitmask
            System.out.println(bitmask);
            System.out.println(1 << num);
            System.out.println((bitmask & (1 << num)) );
            if ((bitmask & (1 << num)) == 0) {
                // If not, add the number to the bitmask and the sum
                bitmask |= (1 << num);
                totalSum += num;
            }
        }

        // Return the sum
        return totalSum;
    }
}
