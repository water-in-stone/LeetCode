package leetcode.dp;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm
 * 思路：
 * 1. 使用BFS遍历节点绝对会超时，题目中需要的只是路径数，所以用DP来做
 * 状态方程：
 *  (1) 上方和左侧均不越界：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 *  (2) 左侧越界：dp[i][j] = dp[i - 1][j]
 *  (3) 上方越界：dp[i][j] = dp[i][j - 1]
 */
public class _62_UniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return Integer.MIN_VALUE;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23, 12));
    }
}
