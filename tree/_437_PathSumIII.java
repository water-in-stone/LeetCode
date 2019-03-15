package leetcode.tree;

/**
 * @author baikal on 2019-03-14
 * @project Algorithm
 * 基本思想：java 双重递归 思路：首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。
 */
public class _437_PathSumIII {
    static int count = 0;

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helpCount(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return count;
    }

    public static void helpCount(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        helpCount(root.left, sum);
        helpCount(root.right, sum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(pathSum(root, 3));
    }
}
