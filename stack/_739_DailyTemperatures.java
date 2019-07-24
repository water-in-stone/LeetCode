package leetcode.stack;

import java.util.LinkedList;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 * 思路：使用栈，里面存放着单调递减的元素，且从数组的末尾开始遍历，充分利用之前已经访问过的元素的性质
 */
public class _739_DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0 || T.length == 1) {
            return new int[0];
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int n = T.length;
        int[] res = new int[n];
        // 从右到左开始遍历
        for (int i = n - 1; i >= 0; i--) {
            // 这是一个递减栈，若T[i]大于等于栈顶元素，则直接pop，直到栈顶元素大于T[i]
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                // 计算出距离
                res[i] = stack.peek() - i;
            }
            // 把当前元素推入栈中
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        System.out.println(dailyTemperatures(temperatures));
    }

}
