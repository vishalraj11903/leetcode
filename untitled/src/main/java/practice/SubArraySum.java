package practice;

public class SubArraySum {
    public static void main(String... args) {
        int[] input = {1, 2, 3, 0, 5};
        int k = 5;

        int left = 0, right = 0;
        int sum = 0;
        int count = 0;
        while (right < input.length) {
            if (input[right] == 0) {
                right++;
                continue;
            }
            sum += input[right];
            while (sum > k) {
                sum -= input[left];
                left++;
            }

            if (sum == k) {
                count++;
            }
            right++;
        }

        System.out.println(count);
    }
}
