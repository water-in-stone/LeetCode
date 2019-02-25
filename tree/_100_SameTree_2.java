package leetcode.tree;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 */
public class _100_SameTree_2 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(4);
        a.right = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(1);
        b.right = new TreeNode(8);

        System.out.println(isSameTree(a, b));
    }
}

