package leetcode.list;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 */
public class _160_IntersectionOfTwoLinkedLists_2 {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    // ListNode b = a.next;
    a.next.next = new ListNode(3);
    a.next.next.next = new ListNode(4);
    ListNode b = new ListNode(0);
    b.next = new ListNode(7);
    // ListNode b = a.next;
    b.next.next = new ListNode(3);
    b.next.next.next = new ListNode(4);

    System.out.println(getIntersectionNode(a, b));

  }
}
