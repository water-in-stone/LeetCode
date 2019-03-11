package leetcode.tree;

/**
 * @author baikal on 2019-03-10
 * @project Algorithm
 */
public class _124_BinaryTreeMaximumPathSum {
    static int maxValue = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxValue;
    }


    /**
     * 这题是经典的 "recursion的返回值并不是我们最后要求的值" 的题型。recursion返回的是从下至上包括当前root的单条最大路径；而我们要求
     * 的maxSum的结果是在recursion的过程中不断更新的，也就是跨过当前root包含左子树和右子树的最大路径
     * <p>
     * Recursion rule:
     * 1. root must be used
     * 2. at most one child can be used
     * 3. maxSum does not have any relationship with recursion function, need to be calculated during every recursive call
     */
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxValue = Math.max(maxValue, left + root.val + right);

        // 关键句，返回此条路径下能获取到的最大值
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
