package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-03-11
 * @project Algorithm
 * 总结参考：https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class _78_Subsets {
    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        int n = nums.length;
        List<Integer> start = new ArrayList<>();
        backTrack(start, nums, 0, n);

        return res;
    }

    public static void backTrack(List<Integer> container, int[] nums, int start, int n) {
        if (container.size() <= n) {
            res.add(container);
        }
        for (int i = start; i < n; i++) {
            container.add(nums[i]);
            // 开始下一轮
            backTrack(new ArrayList<>(container), nums, i + 1, n);
            container.remove(container.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
