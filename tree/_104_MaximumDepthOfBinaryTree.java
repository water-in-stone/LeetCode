package leetcode.tree;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 */
public class _104_MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(2);

        System.out.println(maxDepth(a));
    }
}
