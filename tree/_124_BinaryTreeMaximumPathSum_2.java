package leetcode.tree;

/**
 * @author baikal on 2019-03-10
 * @project Algorithm
 */
public class _124_BinaryTreeMaximumPathSum_2 {

    static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        // 回溯法DFS遍历，对于每个
        dfs(root);
        return max;
    }
    
    public static int dfs(TreeNode root){
        if(root == null) return 0;
        // 分别计算左右子树能得到的最大收益
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        int maxValCurrentNode = root.val + leftMax + rightMax;
        max = Math.max(max, maxValCurrentNode);
        // 关键句，返回此条路径下能获取到的最大值
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
