package leetcode.tree;

import java.util.*;

/**
 * @author baikal on 2019-07-25
 * @project Algorithm
 */
public class _114_FlattenBinaryTreeToLinkedList {

  static TreeNode prev = null;

  public static void flatten(TreeNode root) {
    if (root == null)
      return;
    flatten(root.right);
    flatten(root.left);
    if (root.left != null) {
      prev = root.left;
      // 找到左子树中的最右节点
      while (prev.right != null) {
        prev = prev.right;
      }
      // 把根节点的右子树指给最右节点的右子树上
      prev.right = root.right;
      // 把根节点的左子树指给右子树
      root.right = root.left;
      root.left = null;
    }
    // 访问下一个节点
    root = root.right;
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(1);
    a.left = new TreeNode(2);
    // a.left.left = new TreeNode(3);
    // a.left.right = new TreeNode(4);
    a.right = new TreeNode(5);
    // a.right.right = new TreeNode(6);
    flatten(a);
  }
}
