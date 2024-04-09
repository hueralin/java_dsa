package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = size;
            while (i > 0) {
                TreeNode node = queue.poll();
                if (i == size) {
                    res.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                i--;
            }
        }
        return res;
    }
}
