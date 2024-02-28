package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            // 记录当前层有多少节点
            int size = q.size();
            List<Integer> level = new LinkedList<>();

            while (size > 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                // 追加下一层的节点
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                size--;
            }

            // 收集当前层的节点
            list.add(level);
        }

        return list;
    }
}
