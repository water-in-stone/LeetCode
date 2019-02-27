package leetcode.backTracking;

import java.util.*;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 * <p>
 * 要点：
 * 1. 回溯时，不需要用stack去判断生产的括号数组是否合法，而是记录当前左括号和右括号的使用次数
 * 2. 回溯法其实就是递归的变种
 */
public class _22_GenerateParentheses {

    public static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new Error("error");
        }

        backTracking("", 0, 0, n);

        return result;
    }

    public static void backTracking(String s, int leftCount, int rightCount, int max) {
        int length = s.length();

        if (length == 2 * max) {
            result.add(s);
        } else {
            if (leftCount < max) {
                backTracking(s + "(", leftCount + 1, rightCount, max);
            }

            // 添加右括号时需要判断左右括号数量是否相等
            if (leftCount > 0 && leftCount - rightCount > 0 && rightCount < max) {
                backTracking(s + ")", leftCount, rightCount + 1, max);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(1);

        System.out.println(res);
    }
}
