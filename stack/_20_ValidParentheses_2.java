package leetcode.stack;

import java.util.*;

/**
 * @author baikal on 2019-07-28
 * @project Algorithm
 * 用一个hashMap来存储对应的key
 */
public class _20_ValidParentheses_2 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    char c2 = stack.pop();
                    boolean isVaid = (c == ')' && c2 == '(' || c == '}' && c2 == '{' || c == ']' && c2 == '[');
                    if (!isVaid) {
                        return false;
                    }
                }
            }
        }
        return stack.size() > 0;
    }

    public static void main(String[] args) {
        String s = "()[{}]";
        // String s = "(";
        System.out.println(isValid(s));
    }
}
