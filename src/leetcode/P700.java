package leetcode;

import basic.TreeNode;

import java.util.Stack;

public class P700 {
    // 递归法
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // 迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.val == val) {
                return node;
            } else if (node.val > val && node.left != null) {
                st.push(node.left);
            } else if (node.val < val && node.right != null) {
                st.push(node.right);
            }
        }

        return null;
    }

    // 迭代法2
    // 因为二叉搜索树是有序的，沿着某条路径查下去即可，
    // 所以不需要全部遍历，没有回溯，不需要额外的栈辅助空间
    public TreeNode searchBST3(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
