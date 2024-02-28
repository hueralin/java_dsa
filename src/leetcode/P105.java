package leetcode;

import basic.TreeNode;

import java.util.Arrays;

public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;

        int idx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                idx = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        int[] rightInorder = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftPreorder.length + 1, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
