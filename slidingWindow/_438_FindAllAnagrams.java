package leetcode.slidingWindow;

import java.util.*;

/**
 * @author baikal on 2019-03-15
 * @project Algorithm
 */
public class _438_FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        char[] c = p.toCharArray();
        Arrays.sort(c);
        String p1 = String.valueOf(c);
        int n = p1.length();

        for (int i = n - 1; i < s.length(); i++) {
            int initIndex = i - (n - 1);
            String s1 = s.substring(initIndex, initIndex + n);
            char[] c2 = s1.toCharArray();
            Arrays.sort(c2);
            s1 = String.valueOf(c2);
            if (s1.equals(p1)) {
                res.add(initIndex);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);

        System.out.println(res);
    }
}
