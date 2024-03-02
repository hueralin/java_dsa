package leetcode;

import basic.TreeNode;

public class P538 {
    private TreeNode prev;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        root.right = convertBST(root.right);

        if (prev != null) {
            root.val += prev.val;
        }
        prev = root;

        root.left = convertBST(root.left);

        return root;
    }

    // 递归 2
    private int prevVal;
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;

        // 先遍历右子树
        convertBST2(root.right);
        // 将上一个节点的值加上
        root.val += prevVal;
        // 当前节点变为 prev
        prevVal = root.val;
        // 开始遍历左子树
        convertBST2(root.left);

        return root;
    }
}
