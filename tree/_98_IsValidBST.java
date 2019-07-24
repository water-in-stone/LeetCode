package leetcode.tree;

import java.util.*;

/**
 * @author baikal on 2019-07-24
 * @project Algorithm
 */
public class _98_IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        boolean isValid = true;
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 考虑到可能存在输入为Integer.MIN_VALUE的情况，还是需要一个队列来存储数据
        LinkedList<Integer> valArray = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 把左节点推入栈中
                stack.push(root);
                root = root.left;
            }
            // 取出当前节点
            root = stack.peek();
            if (valArray.size() > 0) {
                // 若当前节点小于等于前一个节点的值，则不是BST
                if (valArray.getLast() >= root.val) {
                    return false;
                }
            }
            valArray.add(root.val);
            stack.pop();
            root = root.right;
        }

        return isValid;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(0);
        System.out.println(isValidBST(a));
    }
}
