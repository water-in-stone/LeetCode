package leetcode.dp;

/**
 * @author baikal on 2019-02-28
 * @project Algorithm
 */
public class _198_HouseRobber_2 {
    public static int rob(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int n  = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            if(dp[i] > max){
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
