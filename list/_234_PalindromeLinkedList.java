package leetcode.list;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm
 * 1.用快慢指针找到中点
 * 2.将中点之后的链表翻转
 * 3.比较两个新链表的值
 */
public class _234_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 用快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null && fast != null){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode newHead = null;
        while (root != null) {
            ListNode head = new ListNode(root.val);
            head.next = newHead;
            newHead = head;

            root = root.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
