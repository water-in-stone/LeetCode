package leetcode.slidingWindow;

import java.util.HashMap;

/**
 * @author baikal on 2019-03-16
 * @project Algorithm
 */
public class _76_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int minWinLength = Integer.MAX_VALUE;
        int minHead = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        int end = 0;
        int begin = 0;
        int count = hashMap.size();

        while (end < s.length()) {
            char c = s.charAt(end);

            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
                if (hashMap.get(c) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                char c1 = s.charAt(begin);

                if (hashMap.containsKey(c1)) {
                    hashMap.put(c1, hashMap.get(c1) + 1);
                    if (hashMap.get(c1) > 0) {
                        count++;
                    }
                }
                int windLength = end - begin;
                if (windLength < minWinLength) {
                    minWinLength = windLength;
                    minHead = begin;
                }
                begin++;
            }
            end++;
        }

        if (minWinLength != Integer.MAX_VALUE) {
            return s.substring(minHead, minWinLength + minHead + 1);
        } else {
            return "";
        }
    }


    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "";
        String t = "A";

        String minWindow = minWindow(s, t);

        System.out.println(minWindow);
    }
}
