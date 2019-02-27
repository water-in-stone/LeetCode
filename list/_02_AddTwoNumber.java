package leetcode.list;

import java.util.*;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 重点在于注意进位的情况
 */
public class _02_AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        // carry是进位
        int carry = 0;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode result = res;

        // 这里处理公共部分的加法
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int bit = sum >= 10 ? sum % 10 : sum;
            carry = sum >= 10 ? 1 : 0;
            res.next = new ListNode(bit);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }


        // 处理剩下的进位
        while (l1 != null) {
            int sum = l1.val + carry;
            int val = sum >= 10 ? sum % 10 : sum;
            carry = sum >= 10 ? 1 : 0;
            res.next = new ListNode(val);
            l1 = l1.next;
            res = res.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int val = sum >= 10 ? sum % 10 : sum;
            carry = sum >= 10 ? 1 : 0;
            res.next = new ListNode(val);
            l2 = l2.next;
            res = res.next;
        }

        if (carry == 1) {
            res.next = new ListNode(1);
        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
//        a.next = new ListNode(4);
//        a.next.next = new ListNode(3);
        ListNode b = new ListNode(8);
        b.next = new ListNode(9);
        b.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(b, a);
        res.log();
    }
}
