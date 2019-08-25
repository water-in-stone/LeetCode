package leetcode.dp;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 */
public class _714_BestTimeToBuyAndSellStock5 {
  public static int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int n = prices.length;
    int[][] dp = new int[n][2];

    dp[0][1] = -prices[0];

    for (int i = 1; i < n; i++) {
      // 在卖出时需要把交易费的钱给减去
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }

    return dp[n - 1][0];
  }

  public static void main(String[] args) {
    int[] n = { 1, 2, 6, 223, 2 };
    System.out.println(maxProfit(n, 2));
  }
}
