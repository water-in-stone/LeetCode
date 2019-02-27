package leetcode.list;

import java.util.*;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 直接合并，这里类似于归并排序，需要在while循环结束后对剩下的两个list做判断
 */
public class _21_MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode result = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }

        return result.next;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        a.next = new ListNode(2);
        a.next.next = new ListNode(1);
        ListNode b = new ListNode(4);
        b.next = new ListNode(3);
        b.next.next = new ListNode(2);
        ListNode res = mergeTwoLists(a, b);
        res.log();
    }


}
