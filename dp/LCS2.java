package leetcode.dp;

/**
 * @author baikal on 2019-07-22
 * @project Algorithm 最长公共子序列 状态转移方程，
 *  当s1[i] = s2[j]时，dp[i][j] = dp[i - 1][j - 1] + 1
 *  当s1[i] != s2[j]时，dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
 */
public class LCS2 {

  public static int getLCS2(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    // 考虑到 i - 1和 j - 1 带来的越界问题和复用性问题，增加一行一列，令i和j从1开始
    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    return dp[n1][n2];
  }

  public static void main(String[] args) {
    String s1 = "helloworld";
    String s2 = "loop";
    System.out.println(getLCS2(s1, s2));
  }
}
