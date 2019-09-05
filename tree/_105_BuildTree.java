package leetcode.tree;

import java.util.HashMap;

/**
 * @author baikal on 2019-07-25
 * @project Algorithm
 * <p>
 * 0.考虑到元素彼此不重复
 * 1.使用hashMap来存储中序遍历中各个元素的位置
 * 2.从前序数组中取出根节点的值
 * 3.++前序数组的索引值
 * 充分利用前序序列的特点
 * 视频解析详见：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-he-zhong-xu-bian-li-xu-lie-gou-zao-er/
 */
public class _105_BuildTree {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        TreeNode res = helper(0, inorder.length, preorder);
        return res;
    }

    /**
     * 
     * @param in_start 表示起始点
     * @param in_end 表示结束点
     * @param preorder 前序遍历结果
     * @return
     */
    public static TreeNode helper(int in_start, int in_end, int[] preorder) {
        // 当起点和终点值相同时，结束递归
        if (in_start == in_end) return null;
        // 依据preIndex的值来取出根节点的值
        int rootVal = preorder[preIndex];

        TreeNode root = new TreeNode(rootVal);
        int index = hashMap.get(rootVal);
        preIndex++;
        // 构建左子树
        root.left = helper(in_start, index, preorder);
        // 构建右子树
        root.right = helper(index + 1, in_end, preorder);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }
}
