package leetcode;

import basic.TreeNode;

import java.util.Stack;

public class P530 {
    // 迭代法
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (prev != null) {
            int x = root.val - prev.val;
            if (x < min) {
                min = x;
            }
        }
        prev = root;
        traversal(root.right);
    }

    // 迭代法
    public int getMinimumDifference2(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        int min = Integer.MAX_VALUE;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                // 处理
                if (prev != null) {
                    int x = curr.val - prev.val;
                    if (x < min) {
                        min = x;
                    }
                }
                prev = curr;
                curr = curr.right;
            }
        }
        return min;
    }
}
