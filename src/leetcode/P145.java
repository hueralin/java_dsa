package leetcode;

import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145 {
    // 迭代之倒反天罡法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        // 访问顺序：根右左
        if (root == null) return res;
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            res.add(top.val);
            if (top.left != null) {
                st.push(top.left);
            }
            if (top.right != null) {
                st.push(top.right);
            }
        }

        // 倒反天罡（反转列表）
        // 访问顺序：左右根，即后序遍历顺序
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
            i++;
            j--;
        }

        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if (root == null) return res;
        TreeNode curr = root;
        // 记录上一个访问的节点
        TreeNode prev = null;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode top = st.peek();
                if (top.right != null) {
                    if (top.right != prev) {
                        // 右孩子没访问过，则开始遍历右孩子
                        curr = top.right;
                    } else {
                        // 右孩子访问过，则 top 出栈并访问
                        // 访问节点
                        res.add(top.val);
                        // 出栈
                        st.pop();
                        // 记录最近访问的节点
                        prev = top;
                    }
                } else {
                    // 没有右孩子，则 top 出栈并访问
                    // 访问节点
                    res.add(top.val);
                    // 出栈
                    st.pop();
                    // 记录最近访问的节点
                    prev = top;
                }
            }
        }

        return res;
    }
}
