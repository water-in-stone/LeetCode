package leetcode.dp;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 */
public class _188_BestTimeToBuy4 {
  public int maxProfit(int k, int[] prices) {
    /**
     * 状态转移方程，https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
     * 其中k表示迄今至今最多进行的交易次数, i表示当前第i天, 最后的0代表
     * 
     * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]); max( 选择 rest
     * , 选择 sell ) 解释：今天我没有持有股票，有两种可能： 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     * 
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) max( 选择 rest ,
     * 选择 buy ) 解释：今天我持有着股票，有两种可能： 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     */
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    // 因为买入后必须要第二天才能卖出，所以当最大交易次数k > n / 2时，认为是可以不限次数来交易的
    if (k > n / 2) {
      return maxProfit_k_inf(prices);
    }

    int maxK = k + 1;
    int[][][] dp = new int[n][maxK][2];
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < maxK; j++) {
        if (i == 0) {
          // 判断下临界情况
          dp[0][j][1] = -prices[0];
          continue;
        }
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        // 注意这里必须是 j - 1
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
      }
    }

    return dp[n - 1][k][0];
  }

  public int maxProfit_k_inf(int[] prices) {
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
    _188_BestTimeToBuy4 Solution = new _188_BestTimeToBuy4();
    int[] n = { 1, 2, 6, 223, 2 };
    System.out.println(Solution.maxProfit(5, n));
  }
}
