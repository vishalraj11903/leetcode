package practice;
import java.util.*;

/**
 * Complexity Analysis
 * Time complexity: O(N×2
 * N
 *  ) to generate all subsets and then copy them into the output list.
 *
 * Space complexity: O(N).
 * We are using O(N) space to maintain curr,
 * and are modifying curr in-place with backtracking.
 * Note that for space complexity analysis, we do not count space that is only used
 * for the purpose of returning output, so the output array is ignored.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        help(nums, 0, nums.length, new ArrayList<>(), result);
        return result;
    }

    void help(int[] nums, int start, int end, List<Integer> aux, List<List<Integer>> result) {
        result.add(new ArrayList<>(aux));
        for (int i = start; i < end; ++i) {
            aux.add(nums[i]);
            help(nums, i + 1, end, aux, result);
            aux.remove(aux.size() - 1);
        }
    }
}
