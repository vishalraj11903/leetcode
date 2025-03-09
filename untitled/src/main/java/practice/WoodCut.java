package practice;

public class WoodCut {
    public static void main(String... args) {
        int[] wood = {5, 9, 7};
        int k = 3;
        int right = 0;
        for (int i = 0; i < wood.length; ++i) {
            right  = Math.max(wood[i], right);
        }

        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canCut(wood, mid) > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);

    }

    static int canCut(int[] wood, int k) {
        int total = 0;
        for (int val : wood) {
            total += (val / k);
        }
        return total;
    }

}
