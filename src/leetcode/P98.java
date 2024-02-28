package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P98 {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        Integer[] arr = list.toArray(new Integer[0]);
        if (arr.length == 0) return true;
        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (prev != -1 && arr[prev] >= arr[i]) return false;
            prev = i;
        }
        return true;
    }
    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}
