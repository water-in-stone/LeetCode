package leetcode.dp;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm
 * 思路：
 * 1. 使用BFS遍历节点绝对会超时，题目中需要的只是路径数，所以用DP来做
 * 2. 既然当前的节点的最小路径值是由上方和左侧（如果存在）的节点的值得到的，由反证法可得，这一定是从最小的上方节点或最小的左侧节点
 *  得到
 *
 * 状态方程：
 * (1) 上方和左侧均不越界：dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
 * (2) 左侧越界：dp[i][j] = dp[i - 1][j] + grid[i][j];
 * (3) 上方越界： dp[i][j] = dp[i][j - 1] + grid[i][j];
 */
public class _64_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }
}
