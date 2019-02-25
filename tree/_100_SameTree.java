package leetcode.tree;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 */
public class _100_SameTree {

    static boolean isSame = true;

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            isSame = true;
        } else {
            dfs(p, q);
        }

        return isSame;
    }

    public static void dfs(TreeNode a, TreeNode b) {
        if (!isSame) return;

        if ((a != null && b == null) || (a == null && b != null)) {
            isSame = false;
        } else if (a != null && b != null) {
            isSame = a.val == b.val;
            dfs(a.left, b.left);
            dfs(a.right, b.right);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);
        System.out.println(isSameTree(a, b));
    }
}

