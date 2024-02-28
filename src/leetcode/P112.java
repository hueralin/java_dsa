package leetcode;

import basic.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

public class P112 {
    // 深度优先遍历 - 递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 这段代码是核心，与遍历顺序无关，前中后序遍历均可
        if (root.left == null && root.right == null) return root.val == targetSum;

        if (root.left != null) {
            if (hasPathSum(root.left, targetSum - root.val)) return true;
        }

        if (root.right != null) {
            if (hasPathSum(root.right, targetSum - root.val)) return true;
        }

        return false;
    }

    // 深度优先遍历，迭代
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 使用栈模拟递归，值为节点和目标值的 pair
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, targetSum));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int sum = p.getValue();

            // 重点，只有是叶子节点，且 node.val == 目标值的才是结果，然后直接返回
            if (node.left == null && node.right == null && node.val == sum) return true;

            if (node.right != null) {
                stack.push(new Pair<>(node.right, sum - node.val));
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, sum - node.val));
            }
        }

        return false;
    }
}
