package leetcode.list;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void log() {
        ListNode root = this;
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
