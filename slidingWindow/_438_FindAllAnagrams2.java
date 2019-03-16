package leetcode.slidingWindow;

import java.util.*;

/**
 * @author baikal on 2019-03-15
 * @project Algorithm
 * 使用滑动窗口法，思路来自leetcode，视频讲解可以参考 https://www.youtube.com/watch?v=tWdMNboG-gI&t=67s
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 *
 */
public class _438_FindAllAnagrams2 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) {
            return res;
        }
        // 创建hashMap来存储目标字符串中的所有字符出现的次数
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int end = 0;
        int begin = 0;
        // 以hashMap的size为准，因为可能有重复字符串，这个count用来标明是否命中了目标字符串
        int count = hashMap.size();

        while (end < s.length()) {
            char c = s.charAt(end);


            // 移动右边的窗口
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
                // 因为可能存在重复字符串，所以必须要 hashMap.get(c) == 0时，count才减1
                if (hashMap.get(c) == 0) {
                    count--;
                }
            }

            // 增加count来使其失效 / 生效
            while (count == 0) {
                char c1 = s.charAt(begin);

                if (hashMap.containsKey(c1)) {
                    hashMap.put(c1, hashMap.get(c1) + 1);
                    if (hashMap.get(c1) > 0) {
                        count++;
                    }
                }

                // 标明命中目标字符串后的操作
                if (end - begin + 1 == p.length()) {
                    res.add(begin);
                }

                begin++;
            }

            end++;
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
