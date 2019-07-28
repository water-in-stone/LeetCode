package leetcode.list;

import java.util.List;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 */
public class _141_LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 定义好快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        // 直接判断两个链表是否相等
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
//        ListNode b = a.next;
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);

        System.out.println(hasCycle(a));

    }
}
