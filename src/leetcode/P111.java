package leetcode;

import basic.TreeNode;

public class P111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int ld = minDepth(root.left);
        int rd = minDepth(root.right);

        // 如果当前节点左孩子为空，右孩子不为空，那么当前节点的最小深度就是右子树的最小深度 +1
        if (root.left == null && root.right != null) {
            return 1 + rd;
        }

        // 如果当前节点右孩子为空，左孩子不为空，那么当前节点的最小深度就是左子树的最小深度 +1
        if (root.right == null && root.left != null) {
            return 1 + ld;
        }

        // 如果左右孩子都不为空，则就取左右子树最小深度的较小者 +1
        return 1 + Integer.min(ld, rd);
    }
}
