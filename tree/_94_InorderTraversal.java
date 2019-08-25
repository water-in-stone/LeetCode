package leetcode.tree;

import java.util.*;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 * 基本思想：
 * 1. 递归版：使用DFS来遍历，且按照父节点在中间的方式去遍历左右节点
 * 2. 非递归版：使用栈来实现后入先出的效果，且模拟中序遍历情况
 */
public class _94_InorderTraversal {
    static List<Integer> res = new LinkedList<>();

    // 递归版
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();

        inorderTraversal(root.left);
        // 在中间访问父节点就是中序遍历，前序和后序遍历以此类推
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }

    /**
     * 非递归版
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 一直访问左子树直到叶子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 开始访问节点
            root = stack.peek();
            res.add(root.val);
            stack.pop();
            root = root.right;
        }

        return res;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(3);
        List<Integer> res = inorderTraversal2(a);
        System.out.println(res);
    }
}
