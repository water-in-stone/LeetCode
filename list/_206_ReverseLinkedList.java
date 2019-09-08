package leetcode.list;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 * 重点在于每次需要新生成节点
 * 因为这里传的是引用的备份（call by sharing），所以直接改变head的赋值不会对原先的值有影响
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
