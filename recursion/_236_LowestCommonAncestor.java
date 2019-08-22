package leetcode.recursion;

/**
 * @author baikal on 2019-07-21
 * 在左、右子树中分别查找是否包含p或q，如果（两种情况：左子树包含p，右子树包含q/左子树包含q，右子树包含p），那么此时的根节点就是最近公共祖先
 * 如果左子树包含p和q，那么到root->left中查找，最近公共祖先在左子树里面
 * 如果右子树包含p和q，那么到root->right中查找，最近公共祖先在右子树里面
 */
public class _236_LowestCommonAncestor {

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      return root;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    TreeNode p = root.left;
    root.left.left = new TreeNode(3);
    TreeNode q = root.left.left;
    TreeNode acestor = lowestCommonAncestor(root, p, q);
    System.out.println(acestor);
  }
}
