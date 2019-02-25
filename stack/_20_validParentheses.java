package leetcode.stack;

import java.util.*;

/**
 * @author baikal on 2019-02-24
 * @project Algorithm
 * 1.想象我们人在处理这道题时，就是一个天天爱消除的游戏，所有的( 、[ 和 { 都需要被匹配和消除
 * 2.栈就可以实现这个效果
 */
public class _20_validParentheses {
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c != hashMap.get(stack.pop())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
