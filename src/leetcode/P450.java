package leetcode;

import basic.TreeNode;

public class P450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            TreeNode leftMax = getMax(root.left);
            if (leftMax != null) {
                root.left = deleteNode(root.left, leftMax.val);
                leftMax.left = root.left;
                leftMax.right = root.right;
                root = leftMax;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    public TreeNode getMax(TreeNode root) {
        if (root == null) return null;

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // root 就是待删除的节点
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 左右均不为空，则寻找左子树中的最大值
            TreeNode curr = root.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            // 将待删除节点的右子树接到最大值节点的右子树上
            curr.right = root.right;
            // 既然 root.right 已经没了，那么新 root 就是老 root 的左子树
            root = root.left;
        }

        return root;
    }
}
