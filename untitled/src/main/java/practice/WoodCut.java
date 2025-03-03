package practice;

public class WoodCut {
    public static void main(String... args) {
        int[] wood = {232,124, 456};
        int k = 7;
        int right = 0;
        for (int i = 0; i < wood.length; ++i) {
            right  = Math.max(wood[i], right);
        }

        int left = 1;
        int res = 0;
        while (left < right) {
            int mid = left +(right - left) / 2;
            if (canCut(wood, mid) >= k) {
                left = mid + 1;
                res = left;
            } else {
                right = mid;
            }
        }

        System.out.println(res);

    }

    static int canCut(int[] wood, int len) {
        int total = 0;
        for (int val : wood) {
            total += (val / len);
        }

        return total;
    }

}
