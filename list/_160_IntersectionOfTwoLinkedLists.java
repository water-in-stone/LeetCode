package leetcode.list;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 *
 * 思路1：
 * 依然是双指针法，若两个链表有相交，则从链表A和B分别出发，走完 A + B - A和B的共同部分 的步数是一样的
 * 总共需要走2轮，第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
 * 时间复杂度O(n), 空间复杂度O(1)
 *
 *
 * 思路2：
 * Young：遍历1遍list A和list B的同时，构造一个反向的链表A和链表B，然后让反向A和B一起开始走，知道出现第1个不相同的节点
 * 时间复杂度O(n), 空间复杂度O(n)
 */
public class _160_IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode b = new ListNode(4);
        b.next = a.next;
        a.next.next = new ListNode(5);
        System.out.println(getIntersectionNode(a, b));
    }
}
