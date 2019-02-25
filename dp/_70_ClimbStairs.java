package leetcode.dp;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 使用dp来做，状态方程很简单
 */
public class _70_ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 0) {
            throw new Error("error");
        }
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
