package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 */
public class _39_CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        backTrack(nums, candidates, 0, target, 0);

        return res;
    }

    public static void backTrack(ArrayList<Integer> nums, int[] candidates, int sum, int target, int start) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(nums));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                nums.add(candidates[i]);
                sum += candidates[i];
                // 开始回溯，且拷贝nums数组
                // i传递至下一次运算是为了避免结果重复
                backTrack(new ArrayList<>(nums), candidates, sum, target, i);

                nums.remove(nums.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
        int[] candidates = {2, 3, 5};
        List<List<Integer>> res = combinationSum(candidates, 8);

        System.out.println(res);
    }
}
