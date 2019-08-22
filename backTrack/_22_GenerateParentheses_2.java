package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 *          <p>
 */
class _22_GenerateParentheses_2 {
    static List<String> res = new LinkedList<>();
    static int length;
    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        length  = 2 *n;
        helper("", n, 0, 0, 0);
        return res;
    }

    // leftP表示"("使用的次数
    public static void helper(String s, int n, int start, int leftP, int rightP){
        if(s.length() > length){
            // 去除一部分多余的路径
            return;
        } else if(s.length() == length){
            res.add(s);
        } else {
            for(int i = start; i < length; i++){
                if(leftP + 1 >= rightP && leftP + 1 <= n){
                    String s1 = s + "(";
                    helper(s1, n, i + 1, leftP + 1, rightP);
                }
                if(leftP >= rightP + 1 && rightP + 1 <= n){
                    String s2 = s + ")";
                    helper(s2, n, i + 1, leftP, rightP + 1);
                }
                
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(2);

        System.out.println(res);
    }
}
