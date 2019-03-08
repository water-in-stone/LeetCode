package leetcode.tree;

import java.util.*;

/**
 * @author baikal on 2019-03-06
 * @project Algorithm
 * 广度优先，并交换左右子树
 */
public class _226_InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            swap(node);
            if (node.left != null){
                list.push(node.left);
            }
            if (node.right != null){
                list.push(node.right);
            }
        }
        return root;
    }

    public static void swap(TreeNode root) {
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        TreeNode res = invertTree(root);
        System.out.println(res);
    }
}
