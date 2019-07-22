package leetcode.dp;

/**
 * @author baikal on 2019-07-22
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
        if (s == null || s.equals("")) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        String longestSubStr = "";
        boolean[][] dp = new boolean[n][n];
        // i为上界，j为下界，往回
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((i - j < 3 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        // 计算出当前状态方程对应的字符串长度
                        if (i - j + 1 > longestSubStr.length()) {
                            longestSubStr = s.substring(j, i + 1);
                        }
                    }
                }
            }
        }

        return longestSubStr;
    }

    public static void main(String[] args) {
//        String s = "abcba";
        String s = "ccc";

        System.out.println(longestPalindrome(s));
    }
}
