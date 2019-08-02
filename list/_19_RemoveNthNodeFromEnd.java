package leetcode.list;

import java.util.List;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 * 思路：list题目中常见的双指针法
 * <p>
 * 具体步骤
 * 1. 让快指针先走n步，然后慢指针开始移动，当快指针到达末尾时，慢指针指向倒数第n个list
 * 2. 因为删除节点需要知道对应节点的上一个节点，所以最后是走到倒数 n-1 节点上
 * <p>
 * 考虑到n大于
 */
public class _19_RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            throw new Error("error");
        }

        ListNode fast = head;
        ListNode nthNode = head;
        ListNode prev = head;

        // 快指针先走
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            prev = nthNode;
            nthNode = nthNode.next;
            fast = fast.next;
        }

        if (prev == nthNode) {
            head = head.next;
        } else {
            prev.next = nthNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(7);

        ListNode res = removeNthFromEnd(a, 2);
        res.log();
    }
}
