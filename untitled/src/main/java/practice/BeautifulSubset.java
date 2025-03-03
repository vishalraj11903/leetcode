package practice;

import java.util.ArrayList;
import java.util.List;

public class BeautifulSubset {

    public static void main(String... args) {
        int[] input = {2, 4, 6};
        int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        help(input, 0, new ArrayList<>(), result, k);
        System.out.println(result);
    }

    static void help(int[] nums, int start, List<Integer> aux, List<List<Integer>> result, int k) {
        if (start > 0) {
            result.add(new ArrayList<>(aux));
        }

        for (int i = start; i < nums.length; ++i) {
            boolean canAdd = true;
            for (int val : aux) {
                if (Math.abs(val - nums[i]) == k) {
                    canAdd = false;
                    break;
                }
            }

            if (canAdd) {
                aux.add(nums[i]);
                help(nums, i + 1, aux, result, k);
                aux.remove(aux.size() - 1);
            }
        }
    }
}
