package leetcode.list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class _92_ReverseLinkedList2 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
      if(head == null){
          return null;
      } else if(head.next == null){
          return head;
      }
      ListNode dump = new ListNode(0);
      dump.next = head;
      ListNode preStart = dump;
      ListNode start = head;
      // 令start指向要翻转的节点
      for(int i = 1; i < m; i++){
          preStart = start;
          start = start.next;
      }
      // 令 A B C D 变成 B A C D 的形式
      for(int j = 0; j < n - m; j++){
          // 得到B
          ListNode temp = start.next;
          // 得到ACD
          start.next = temp.next;
          // 得到BACD，通过preStart来实现
          temp.next = preStart.next;
          preStart.next = temp;
          
      }

      return dump.next;
  }
}