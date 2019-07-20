package leetcode.tree;

/**
 * @author baikal on 2019-03-18
 * @project Algorithm
 * 思路：逆向中序遍历，先遍历右孩子并记录其值
 * 5
 * /   \
 * 2    13
 */
public class _538_ConvertBstToGreaterTree {
    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public static void convert(TreeNode root) {
        if (root == null) return;
        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        TreeNode res = convertBST(root);

        System.out.println(res);
    }
}
