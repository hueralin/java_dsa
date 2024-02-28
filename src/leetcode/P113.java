package leetcode;

import basic.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        traversal(root, new LinkedList<>(), targetSum, res);
        return res;
    }

    public void traversal(TreeNode node, Deque<Integer> path, int target, List<List<Integer>> res) {
        // 到达路径终点，即叶子节点，产生解的地方
        if (node.left == null && node.right == null && node.val == target) {
            path.offerLast(node.val);
            res.add((List<Integer>) new LinkedList<>(path));
        }
        if (node.left != null) {
            path.offerLast(node.val);
            traversal(node.left, path, target - node.val, res);
            path.pollLast();
        }
        if (node.right != null) {
            path.offerLast(node.val);
            traversal(node.right, path, target - node.val, res);
            path.pollLast();
        }
    }
}
