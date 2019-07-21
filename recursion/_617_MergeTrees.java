package leetcode.recursion;

import leetcode.tree.dfs;

/**
 * @author baikal on 2019-07-21
 * @project Algorithm
 */
public class _617_MergeTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else {
            int val = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
            TreeNode root = new TreeNode(val);
            // 直接返回当前新的节点
            root.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
            root.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.right = new TreeNode(2);
        a.left.left = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(1);
        b.right = new TreeNode(3);
        b.left.right = new TreeNode(4);
        b.right.right = new TreeNode(7);
        TreeNode c = mergeTrees(a, b);
        System.out.println(c);
    }
}
