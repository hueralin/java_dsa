package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root == null) return res;

        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = st.pop();
                res.add(top.val);
                if (top.right != null) {
                    curr = top.right;
                }
            }
        }

        return res;
    }
}
