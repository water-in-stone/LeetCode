package leetcode.tree;

import java.util.*;

/**
 * @author baikal on 2019-07-25
 * @project Algorithm
 * 使用广度遍历，且每一次遍历的时计算queue的size，这个size就是当前level应有的节点数
 */
public class _102_LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new LinkedList<>();
            // queue的size就是当前level应有的节点数
            int levels = queue.size();
            for (int i = 0; i < levels; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                levelNodes.add(node.val);
            }
            res.add(levelNodes);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.left = new TreeNode(15);
        a.right.right = new TreeNode(7);
        levelOrder(a);
    }
}
