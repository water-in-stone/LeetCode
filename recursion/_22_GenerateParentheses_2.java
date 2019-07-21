package leetcode.recursion;

import java.util.*;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm 要点：
 * 1.不需要用stack去判断生产的括号数组是否合法，而是记录当前左括号和右括号的使用次数，再结合左右括号的添加时机
 *
 */
public class _22_GenerateParentheses_2 {

    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new Error("error");
        }

        helper("", n, n);

        return result;
    }

    public static void helper(String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        } else {
            if (left > 0) {
                helper(s + "(", left - 1, right);
            }
            if (right > 0 && left < right) {
                helper(s + ")", left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);

        System.out.println(res);
    }
}
