package leetcode.list;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm
 * 1.用快慢指针找到中点
 * 要求 O(1) 的空间，那就只能从链表本身动手了。首先判断回文无非就是从两边到中间或者从中间到两边。由于我们可以对链表本身动手，那就考虑
 * 让链表能够倒着访问（因为要求O(1)空间，所以不能直接改造为双向链表）。由于我们只能让链表顺着一个方向走，所以可以想到选择从中间到两边的
 * 方式，左边的向前(pre)，右边的向后(next)。
 *
 */
public class _234_PalindromeLinkedList2 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode mid;
        // 用快慢指针找到中点
        while (fast != null && fast.next != null) {
            // 在链表自身中记录pre
            slow.next.pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 依据链表长度为奇数或偶数分开处理中点
        if (fast == null){
            mid = slow;
        } else {
            // 偶数
            mid = slow;
            slow = slow.next;
        }

        while (slow != null && mid != null){
            if (slow.val != mid.val){
                return false;
            }
            slow = slow.next;
            mid = mid.pre;
        }

        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
