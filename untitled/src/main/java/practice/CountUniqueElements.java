package practice;

public class CountUniqueElements {
    public static int countUnique(int[] arr) {
        if (arr.length == 0) return 0;

        int uniqueCount = 1; // First element is always unique

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 7, 7, 8, 8, 10};
        System.out.println("Number of unique elements: " + countUnique(arr));
    }
}
