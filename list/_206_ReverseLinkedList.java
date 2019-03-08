package leetcode.list;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 * 重点在于每次需要新生成节点
 */
public class _206_ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode start = null;

        while (head != null) {
            ListNode newHead = new ListNode(head.val);
            newHead.next = start;
            start = newHead;
            head = head.next;
        }

        return start;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode b = reverseList(a);
        b.log();
    }
}
