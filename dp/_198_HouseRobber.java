package leetcode.dp;

/**
 * @author baikal on 2019-02-28
 * @project Algorithm
 * 简单DP的题目，状态方程如下
 * dp[i] = max(dp[i - 2] + nums[i] , dp[i - 1])
 * 1. dp[i - 2] + nums[i] 代表偷取了当前房屋后的总钱数
 * 2. dp[i - 1]代表不偷当前房屋后的总钱数
 */
public class _198_HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int length = nums.length;
        int[] dp = new int[length];
        int max = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};

        System.out.println(rob(nums));
    }
}
