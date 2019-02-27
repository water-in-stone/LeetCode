package leetcode.stack;

import java.util.*;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 */
public class _121_BestTimeToBuySell {
    public static int maxProfit(int[] prices) {
        if (prices == null) {
            throw new Error("error");
        }
        if (prices.length == 0) {
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int length = prices.length;
        int profit = 0;
        int newProfit = 0;
        stack.push(prices[0]);

        for (int i = 1; i < length; i++) {
            int val = prices[i];

            if (val < stack.peek()) {
                stack.pop();
                stack.push(val);
            } else {
                newProfit = val - stack.peek();
                profit = newProfit > profit ? newProfit : profit;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
//        int[] example = {7, 1, 5, 3, 6, 4};
        int[] example = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(example));
    }
}
