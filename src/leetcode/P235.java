package leetcode;

import basic.TreeNode;

public class P235 {
    // 递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;

        // root 在中间
        if (root.val > p.val && root.val < q.val || root.val > q.val && root.val < p.val) return root;
        // root 在左边
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // root 在右边
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }

    // 递归精简
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 这个判断可以不写，首先是题目要求，p、q 一定在树中，所以 root 不可能为空
        // 其次是递归的过程中，访问 left，right 是因为对应的方向有 p、q，所以也不可能为空
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // root 在 p、q 之间，或者就是 p、q 时的情况
            return root;
        }
    }

    // 迭代法
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // 本质还是不断划分区间，持续深入
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }
}
