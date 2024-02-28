package leetcode;

import basic.TreeNode;

public class P404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 其实这个也可以不写，不写不影响结果，但就会让递归多进行了一层。
        if (root.left == null && root.right == null) return 0;

        int lh = sumOfLeftLeaves(root.left);
        int rh = sumOfLeftLeaves(root.right);

        // 左叶子，只会在左叶子执行
        // 回到 root，判断是否有左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            lh = root.left.val;
        }

        return lh + rh;
    }
}
