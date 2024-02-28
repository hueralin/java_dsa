package leetcode;

import basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        helper(root, "", res);
        return res;
    }

    public void helper(TreeNode node, String path, List<String> res) {
        path += node.val;
        // 叶子节点，一个解
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        if (node.left != null) {
            // 这里并没有修改 path 的值
            helper(node.left, path + "->", res);
            // 但也是实现了回溯
        }
        if (node.right != null) {
            helper(node.right, path + "->", res);
        }
    }
}
