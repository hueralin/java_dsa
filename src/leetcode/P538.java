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
        traversal(root);
        return root;
    }
    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.right);

        root.val += prevVal;
        prevVal = root.val;

        traversal(root.left);
    }
}
