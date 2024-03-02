package leetcode;

import basic.TreeNode;

public class P669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // root 不在区间内，直接返回，换根
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // root 在区间内，保留，查看左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    // 迭代法
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;

        // 先搞定 root，让 root 在区间内，原 root 可能会被抛弃掉
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                // root 小于下界，则遍历右子树
                root = root.right;
            } else {
                // root 大于上界，则遍历左子树
                root = root.left;
            }
        }

        // 用于遍历（此时 root 在区间内）
        TreeNode curr = root;

        // 搞定 root 的左子树
        while (curr != null) {
            while (curr.left != null && curr.left.val < low) {
                // 左子树的值小于下界，那就舍弃左子树的根节点和左子树的左子树，遍历左子树的右子树
                // 这是一个技巧，直接替换掉不满足条件的，保证 while 能继续遍历
                curr.left = curr.left.right;
            }
            // 继续往左遍历
            // 根据二叉搜索树的性质，当前节点大于下界，则当前节点的右子树都大于下界，所以一直探查左侧即可
            // 当前节点小于下界的处理在上面，会往右子树探查的
            curr = curr.left;
        }

        // 回过头来，开始遍历右子树
        curr = root;

        // 同理搞定 root 的右子树
        while (curr != null) {
            while (curr.right != null && curr.right.val > high) {
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }

        return root;
    }
}
