package leetcode;

import basic.TreeNode;

public class P110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        int lh = getHeight(node.left);
        if (lh == -1) return -1;
        int rh = getHeight(node.right);
        if (rh == -1) return -1;

        // 左右子树的高度差大于 1，不是平衡二叉树
        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
