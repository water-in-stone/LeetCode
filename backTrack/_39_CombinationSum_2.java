package leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 */
public class _39_CombinationSum_2 {

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        backTrack(new ArrayList<>(), candidates, 0, 0, target);

        return res;
    }

    public static void backTrack(List<Integer> store, int[] nums, int sum, int begin, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(store));
        } else {
            for (int i = begin; i < nums.length; i++) {
                store.add(nums[i]);
                backTrack(new ArrayList<>(store), nums, sum + nums[i], i, target);
                store.remove(store.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // int[] candidates = {2, 3, 6, 7};
        // int[] candidates = { 2, 3, 5 };
        int[] candidates = { 2, 3 };
        List<List<Integer>> res = combinationSum(candidates, 8);

        System.out.println(res);
    }
}
