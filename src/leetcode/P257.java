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

    public void helper(TreeNode root, String path, List<String> res) {
        if (root == null) return;

        // 进来就是访问，先拼接访问路径
        path += root.val;

        // 到达叶子节点，放入结果集
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }

        // 否则继续深入遍历，这里的 path + "->" 就是深入
        // 而深入递归完，path 没变，就是回溯
        helper(root.left, path + "->", res);
        helper(root.right, path + "->", res);
    }
}
