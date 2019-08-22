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
import java.util.*;

public class _139_WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        // 使用动态规划
        // dp[0]为空字符串""，认为处于字典中
        // dp[i] 表示以s.substring(0, i + 1)结尾的字符串是否处于字典中
        // dp[i] = 循环判断 (dp[j] && s.substring(j, i + 1))
        if (s == null || s.equals("")) {
            return true;
        } else if (dict.size() == 0) {
            return false;
        }
        dict.add("");
        int n = s.length();
        boolean[] dp = new boolean[n];
        // dp[0] = true;
        for (int i = 0; i < n; i++) {
            // 判断子串是否能由字典构成
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    if (dict.contains(s.substring(i, j))) {
                        dp[i] = true;
                        break;
                    }
                } else if (dp[j] && dict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // String s = "abcba";
        String s = "ccc";

        // System.out.println(wordBreak(s));
    }
}
