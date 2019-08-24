package leetcode.recursion;

/**
 * @author baikal on 2019-07-21 可以把根节点看作一个很特殊的节点。因为打劫直接相连的房子会引发报警，所以当打劫了根节点后，
 *         便不能打劫左右的子节点。那么，就可以把问题简化成打劫根节点与不打劫根节点中求最大值的问题。
 */
public class _337_HouseRobber {

  // 返回此树可抢劫时的最大值
  public static int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int robCur = root.val + robWithoutRoot(root.left) + robWithoutRoot(root.right);
    int robWithoutCur = rob(root.left) + rob(root.right);

    return Math.max(robCur, robWithoutCur);
  }

  // robWithoutRoot返回当前点不可拿的时候，此树能抢劫的最大值
  public static int robWithoutRoot(TreeNode root) {
    return root == null ? 0 : rob(root.left) + rob(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    int res = rob(root);
    System.out.println(res);
  }
}
