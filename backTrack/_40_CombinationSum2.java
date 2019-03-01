package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 */
public class _40_CombinationSum2 {
    static List<List<Integer>> res2 = new ArrayList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        // 使数组变得有序，便于去重
        Arrays.sort(candidates);
        ArrayList<Integer> nums = new ArrayList<>();
        backTrack(nums, candidates, 0, target, 0);

        return res2;
    }

    public static void backTrack(ArrayList<Integer> nums, int[] candidates, int sum, int target, int start) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res2.add(new ArrayList<>(nums));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue; // 因为数组是有序的，所以可以跳过添加重复的元素
                nums.add(candidates[i]);
                sum += candidates[i];
                // i传递至下一次运算是为了避免结果重复
                backTrack(new ArrayList<>(nums), candidates, sum, target, i + 1);  // i + 1表示从数组的下一项开始添加

                nums.remove(nums.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = combinationSum2(candidates, 8);

        System.out.println(res);
    }
}
