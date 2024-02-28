package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P513 {
    // 迭代法 - 层序遍历
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // i == 0 时，node 就是当前层第一个进队的元素，即左孩子
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }

    // 递归法 - 前中后序遍历
    private int maxDepth = Integer.MIN_VALUE;
    private int result;
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 1);
        return result;
    }

    public void helper(TreeNode node, int depth) {
        // 叶子节点
        // 这段代码是核心，与遍历顺序无关，前中后序遍历均可
        if (node.left == null && node.right == null) {
            // 找深度最深的节点（即最后一层）
            // 因为是前中后序遍历，左节点的遍历一定在右节点之前
            // 所以即便最后一层有左右两个子节点，也一定是左节点执行这个判断，更新 maxDepth、result
            // 右节点排不上号，这就保证了找到最后一层最靠左的节点
            if (depth > maxDepth) {
                maxDepth = depth;
                result = node.val;
            }
        }

        if (node.left != null) {
            depth++;
            helper(node.left, depth);
            depth--;
        }

        if (node.right != null) {
            depth++;
            helper(node.right, depth);
            depth--;
        }
    }
}
