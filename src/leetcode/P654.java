package leetcode;

import basic.TreeNode;

import java.util.Arrays;

public class P654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int rootVal = Integer.MIN_VALUE;
        int rootIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > rootVal) {
                rootVal = nums[i];
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, rootIdx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, rootIdx + 1, nums.length));
        return root;
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int left, int right) {
        if (left >= right) return null;

        int rootVal = Integer.MIN_VALUE;
        int rootIdx = -1;
        for (int i = left; i < right; i++) {
            if (nums[i] > rootVal) {
                rootVal = nums[i];
                rootIdx = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = traversal(nums, left, rootIdx);
        root.right = traversal(nums, rootIdx + 1, right);
        return root;
    }
}
