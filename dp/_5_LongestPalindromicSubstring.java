package leetcode.dp;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 * 使用DP来做，时间复杂度为O(n ^ 2)，空间复杂度为 O(n ^ 2)
 * 状态转移方程
 * true, 如果子串S(i) … S(j) 是回文子串
 * P(i,j)={
 * false, 其他情况
 * ​
 * P(i, i) = P(i + 1, j - 1) &&  S(i) == S(j)
 * ​P(i, i + 1) = S(i) == S(i + 1)
 */
public class _5_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null) throw new Error("error");
        if (s.length() == 1 || s.equals("")) return s;

        int n = s.length();
        int length = 0;
        int newLength = 0;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[n][n];

        // 这里i为右边界，j为左边界
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0) {
                // 进行状态方程的判断
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    newLength = i - j + 1;

                    // 保存最长回文串的位置
                    if (length < newLength) {
                        left = j;
                        right = i;
                        length = newLength;
                    }
                }
                j--;
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "abcba";

        System.out.println(longestPalindrome(s));
    }
}
