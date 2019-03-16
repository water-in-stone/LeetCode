package leetcode.slidingWindow;

import java.util.*;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 本质上是使用了滑动窗口来查找不重复的子字符串，同时使用hashMap来记录每个字符在数组中的最大位置
 */
public class _03_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0, j = 0; j < length; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                // 找出(i, j)窗口中的下限i
                i = Math.max(i, hashMap.get(s.charAt(j)) + 1);
            }
            res = Math.max(res, j - i + 1);
            // 将当前字符的位置存储起来，即(i,j)窗口中的上限j
            hashMap.put(s.charAt(j), j);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
