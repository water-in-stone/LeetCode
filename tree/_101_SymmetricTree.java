package leetcode.tree;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 重点
 */
public class _101_SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);

        return false;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
//

        System.out.println(isSymmetric(a));
    }
}
