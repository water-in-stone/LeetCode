package leetcode.dp;

/**
 * @author baikal on 2019-07-22
 * @project Algorithm
 * 经典DP问题，状态转移方程如下：
 * dp[i][j] =
 *     1. s.charAt(i) == s.charAt(j),
 *     2. dp[i+1][j-1] 代表小一级的字符串 && 两边的字符相等
 *
 *
 */
public class _647_CountSubstrings {

    public static int countSubstrings(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        // i为上界，j为下界，往回追溯
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((i - j < 3 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        String s = "aaa";
        String s = "aaaaa";
        System.out.println(countSubstrings(s));
    }
}
