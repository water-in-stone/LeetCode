package leetcode.recursion;

/**
 * @author baikal on 2019-07-21
 * @project Algorithm 使用递归遍历的方法
 */
public class _494_FindTargetSumWays_2 {

    static int count = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        helper(0, nums, 0, S);
        return count;
    }

    public static void helper(int sum, int[] nums, int left, int target) {
        if (left == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            helper(sum + nums[left], nums, left + 1, target);
            helper(sum - nums[left], nums, left + 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println(findTargetSumWays(nums, 3));
    }
}
