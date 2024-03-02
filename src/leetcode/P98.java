package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 中序遍历，双指针技巧，记住上一个遍历的节点。根据二叉搜索树的有序性，中序遍历中上一个节点的值一定比当前节点的值小。

public class P98 {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // 左子树是不是 BST，不是就返回 false
        boolean lb = isValidBST(root.left);
        if (!lb) return false;

        // 上个节点的值是否大于当前节点，是则失序，返回 false
        if (prev != null && prev.val >= root.val) return false;
        // root 作为 prev，开始遍历右子树
        prev = root;

        // 右子树是不是 BST，不是就返回 false
        boolean rb = isValidBST(root.right);
        if (!rb) return false;

        return true;
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
