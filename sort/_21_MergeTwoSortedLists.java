package leetcode.sort;

import java.util.*;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm 本质上就是归并排序
 */
public class _21_MergeTwoSortedLists {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    } else if (l1 == null && l2 != null) {
      return l2;
    } else if (l1 != null && l2 == null) {
      return l1;
    }
    // 建立一个起始节点，便于使用它的root.next值
    ListNode root = new ListNode(Integer.MIN_VALUE);
    ListNode res = root;
    while (l1 != null && l2 != null) {
      if (l1.val >= l2.val) {
        // 不去改变当前节点的指向，而是依据值去创建next节点，然后再改变指向
        root.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        root.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      // 指向下一个节点
      root = root.next;
    }

    while (l1 != null) {
      root.next = new ListNode(l1.val);
      root = root.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      root.next = new ListNode(l2.val);
      root = root.next;
      l2 = l2.next;
    }

    return res.next;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(4);
    ListNode b = new ListNode(1);
    b.next = new ListNode(7);
    b.next.next = new ListNode(9);

    ListNode res = mergeTwoLists(b, a);
    System.out.println(res);
  }
}
