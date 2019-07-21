package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-07-21
 * @project Algorithm
 */
public class _17_LetterCombinations {
    static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == null)
            return res;
        if (digits.equals("")) {
            return res;
        }
        String[] phone = { " ", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };
        List<String> number = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1') {
                number.add(phone[Integer.parseInt(digits.substring(i, i + 1))]);
                n++;
            }
        }
        backTrack("", number, 0, n);

        return res;
    }

    public static void backTrack(String s, List<String> number, int start, int n) {
        if (start == n) {
            // 判断回溯结束的条件
            res.add(s);
            return;
        } else {
            if (start < n) {
                // 取出号码对应的String
                String store = number.get(start);
                for (int j = 0; j < store.length(); j++) {
                    backTrack(s + store.charAt(j), number, start + 1, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        // List<String> res = letterCombinations("");
        System.out.println(res);
    }
}
