package leetcode.dp;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 */
public class _121_BestTimeToBuy {
  public static int maxProfit(int[] prices) {
    // 状态转移方程
    // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
    // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
    // 这里k = 1（至今可以进行的最大交易次数）， 则方程简化为：
    // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    // dp[i][1] = max(dp[i - 1][1], -prices[i]);
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    // 代表第一天直接买入
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }

    return dp[n - 1][0];
  }

  public static void main(String[] args) {
    int[] n = { 1, 2, 6, 223, 2 };
    System.out.println(maxProfit(n));
  }
}
