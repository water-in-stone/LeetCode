package leetcode.tree;

/**
 * @author baikal on 2019-03-10
 * @project Algorithm
 */
public class dfs {

    public static void dfs(TreeNode root) {
        if (root == null){
            return;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        dfs(root);
    }
}
