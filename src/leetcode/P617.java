package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        int root1Val = root1 == null ? 0 : root1.val;
        int root2Val = root2 == null ? 0 : root2.val;
        TreeNode node = new TreeNode(root1Val + root2Val);

        node.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return node;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        // root1 为空，就返回 root2，即便 root2 为空也满足条件，下面同理
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 复用 root1 的节点，root2 也行
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root1);
        q.offer(root2);

        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();

            n1.val = n1.val + n2.val;

            if (n1.left != null && n2.left != null) {
                q.offer(n1.left);
                q.offer(n2.left);
            }

            if (n1.right != null && n2.right != null) {
                q.offer(n1.right);
                q.offer(n2.right);
            }

            if (n1.left == null && n2.left != null) {
                n1.left = n2.left;
            }

            if (n1.right == null && n2.right != null) {
                n1.right = n2.right;
            }
        }

        return root1;
    }
}
