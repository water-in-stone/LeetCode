package leetcode.stack;

import java.util.*;

/**
 * @author baikal on 2019年08月25日11:38:58
 * @project Algorithm 对于括号匹配问题，用栈就对了
 */
public class _394_DecodeString {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                multi = 0;
                stack_res.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                // 从栈中取出对应的值并拼凑字符串
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 可能会出现23这样大于10的数字，那么需要 * 10 处理
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
