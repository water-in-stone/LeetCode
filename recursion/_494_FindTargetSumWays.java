package leetcode.recursion;

/**
 * @author baikal on 2019-07-21
 * @project Algorithm
 * 直接DFS进行遍历
 */
public class _494_FindTargetSumWays {
    static int count = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, 0, S);

        return count;
    }

    public static void dfs(int[] nums, int sum, int start, int target) {
        if (start == nums.length) {
            if (target == sum) {
                count++;
            }
            return;
        } else {
            dfs(nums, sum + nums[start], start + 1, target);
            dfs(nums, sum - nums[start], start + 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println(findTargetSumWays(nums, 3));
    }
}
