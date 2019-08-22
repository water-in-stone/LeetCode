package leetcode.dp;

import java.util.*;
/**
 * @author baikal on 2019-07-22
 * @project Algorithm
 * 使用DP来做，时间复杂度为O(m * n)，空间复杂度为 O(m * n)
 * dp(i, j)表示以i,j 作为右下角的顶点的最大正方形的边长
 * dp(i, j) = min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1)) + 1
 */

public class _221_MaximalSquare {
  public static int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int columns = rows == 0 ? 0 : matrix[0].length;
    // 代表最大边长
    int maxEdge = 0;
    // 考虑到数组越界，令dp数组长度比原先大一圈
    int[][] dp = new int[rows + 1][columns + 1];
    for(int i = 1; i <= rows; i++){
        for(int j = 1; j <= columns; j++){
            if(matrix[i - 1][j - 1] == '1'){
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxEdge = Math.max(dp[i][j], maxEdge);
            }
        }
    }
    
    return maxEdge * maxEdge;
  }

  public static void main(String[] args) {
    char[][] s = { { 1, 1 }, { 0, 0 } };

    System.out.println(maximalSquare(s));
  }
}
