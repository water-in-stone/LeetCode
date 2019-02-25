package leetcode.dp;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 使用DP来做，dp[i]表示以nums[i]为结尾的元素所构成的最大子数组的元素和
 */
public class _53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = nums[0];
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = max < dp[i] ? dp[i] : max;

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, -3, 5, 2, 8};
        System.out.println(maxSubArray(a));
    }
}
