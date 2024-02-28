package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P222 {
    // 后序遍历
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int ls = countNodes(root.left);
        int rs = countNodes(root.right);
        return ls + rs + 1;
    }

    // 层序遍历
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            count++;
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return count;
    }

    // 针对完全二叉树
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;

        TreeNode l = root.left;
        TreeNode r = root.right;
        int ls = 0;
        int rs = 0;

        while (l != null) {
            l = l.left;
            ls++;
        }

        while (r != null) {
            r = r.right;
            rs++;
        }

        // 判断是否为 “满二叉树”
        // 满二叉树的节点数量为 2 ^ 高度 - 1
        if (ls == rs) {
            return (2 << ls) - 1;
        }

        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }
}
