package leetcode;

import basic.TreeNode;

public class P108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int l, int r) {
        if (l > r) return null;
        // 优化，如果 l、r 相等，则直接生成节点并返回，不用再往下递归了
        if (l == r) return new TreeNode(nums[l]);
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = traversal(nums, l, mid - 1);
        node.right = traversal(nums, mid + 1, r);
        return node;
    }
}
