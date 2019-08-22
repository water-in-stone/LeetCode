package leetcode.dp;

/**
 * 状态转移方程 dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] dp[i][1] =
 * max(dp[i-1][1], dp[i-2][0] - prices[i])
 */
public class _309_BestTimeToSell {
  public static int maxProfit(int[] prices) {

    if (prices == null || prices.length == 0) {
      return 0;
    }

    int n = prices.length;
    int[][] dp = new int[n][2];
    // 初始化
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      // 处理下边界情况
      if (i - 2 == -1) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        continue;
      }
      // 当天选择卖出股票，能获得的最大收益
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      // 当天选择持有股票，能获得的最大收益
      // 1. 之前就持有
      // 2. 2天前没有持有，今天买入了
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
    }

    return dp[n - 1][0];
  }

  public static void main(String[] args) {
    // int[] nums = { 1, 2, 3, 0, 2 };
    int[] nums = { 2, 1, 2, 0, 1 };
    int res = maxProfit(nums);
    System.out.println(res);
  }
}