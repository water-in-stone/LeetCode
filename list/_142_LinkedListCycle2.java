package leetcode.list;

import java.util.*;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm 思路：用一个 Set 保存已经访问过的节点，遍历整个列表并返回第一个出现重复的节点。
 */
public class _142_LinkedListCycle2 {
  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    HashSet<ListNode> hashSet = new HashSet<>();
    hashSet.add(head);
    hashSet.contains(head);

    while (head != null) {
      if (hashSet.contains(head)) {
        return head;
      }
      hashSet.add(head);
      head = head.next;
    }

    return null;
  }

  /**
   * 快慢指针法：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
   * 
   * @param head
   * @return
   */
  public static ListNode detectCycle2(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    // 定义好快慢指针，且从原地开始起跑
    ListNode slow = head;
    ListNode fast = head;
    boolean hasCycle = false;
    // 直接判断两个链表是否相等
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        hasCycle = true;
        break;
      }
    }
    if (hasCycle) {
      ListNode node1 = head;
      while (node1 != slow) {
        slow = slow.next;
        node1 = node1.next;
      }
      return node1;
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(3);
    a.next = new ListNode(2);
    ListNode b = a.next;
    // ListNode b = a.next;
    a.next.next = new ListNode(0);
    a.next.next.next = new ListNode(-4);
    a.next.next.next.next = b;

    System.out.println(detectCycle2(a));

  }
}
