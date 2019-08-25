package leetcode.dp;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 */
public class _123_BestTimeToBuy3 {
  public static int maxProfit(int[] prices) {
    // 状态转移方程，https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
    // 其中k表示迄今为止做的最大的交易次数, i表示当前第i天, 最后的0代表
    /**
     * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
     *    max(   选择 rest  ,           选择 sell      )
     * 解释：今天我没有持有股票，有两种可能：
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     * 
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *    max(   选择 rest  ,           选择 buy         )
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     *  */
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    int[][][] dp = new int[n][3][2];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        // 判断下临界情况
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        continue;
      }
      for (int j = 1; j < 3; j++) {
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
      }
    }

    return dp[n - 1][2][0];
  }

  public static void main(String[] args) {
    int[] n = { 1, 2, 6, 223, 2 };
    System.out.println(maxProfit(n));
  }
}
