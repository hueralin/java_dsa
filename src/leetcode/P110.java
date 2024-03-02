package leetcode;

import basic.TreeNode;

public class P110 {
    public boolean isBalanced(TreeNode root) {
        // 不等于 -1，说明是平衡的
        return getHeightX(root) != -1;
    }

    public int getHeightX(TreeNode root) {
        if (root == null) return 0;

        int lh = getHeightX(root.left);

        // 有一个子树不平衡，则整个树都不是平衡二叉树，用 -1 标志，及时返回
        if (lh == -1) return -1;

        int rh = getHeightX(root.right);

        // 有一个子树不平衡，则整个树都不是平衡二叉树，用 -1 标志，及时返回
        if (rh == -1) return -1;

        // 高度差大于 1，则不是平衡二叉树
        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
