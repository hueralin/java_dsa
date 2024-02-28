package leetcode;

import basic.TreeNode;

public class P701 {
    // 递归法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            // 保持右子树的衔接
            root.right = insertIntoBST(root.right, val);
        } else {
            // 保持左子树的衔接
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    // 迭代法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true) {
            if (curr.val < val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                } else {
                    curr = curr.right;
                }
            } else if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }

        return root;
    }

    // 迭代法 - 记住父节点
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        // 记录父节点
        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null) {
            // 每次遍历更新父节点
            parent = curr;
            if (curr.val < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // 挂载节点
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
