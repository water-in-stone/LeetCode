package leetcode.slidingWindow;

import java.util.*;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 本质上是使用了滑动窗口来查找不重复的子字符串，同时使用hashMap来记录每个字符在数组中的最大位置
 */
public class _03_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        int n = s.length();
        // 窗口为 [i,j)
        int i = 0;
        for(int j = 0; j < n; j++ ){
            char c = s.charAt(j);
            if(hashMap.containsKey(c)){
                // 找出下限i
                i = Math.max(i, hashMap.get(c));
            }
            res = Math.max(res, j - i + 1);
            // 因为是一个左闭右开的数组，所以每次存入的应该是 j + 1，即数组下一个index的值
            hashMap.put(c, j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
