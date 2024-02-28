package leetcode;

import basic.TreeNode;

public class P104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Integer.max(lh, rh) + 1;
    }
}
