package leetcode;

import java.util.Arrays;
import basic.TreeNode;

public class P106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) return root;

        int idx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                idx = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, postorder.length - 1);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
