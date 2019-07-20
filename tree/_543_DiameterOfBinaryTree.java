package leetcode.tree;

/**
 * @author baikal on 2019-07-20
 * @project Algorithm
 * 核心思想：深度遍历（DFS）；
 * 思路：一个最长的直径肯定是以某个结点为根节点的子树的左右子树高度之和。只需要深搜遍历即可。
 */
public class _543_DiameterOfBinaryTree {

    static int max;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        depth(root);

        return max;
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftLength = depth(root.left);
        int rightLength = depth(root.right);
        max = Math.max(max, leftLength + rightLength);

        return Math.max(leftLength, rightLength) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(a));
    }
}
