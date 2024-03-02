package leetcode;

import basic.TreeNode;

import java.util.*;

public class P501 {
    // 没利用到二叉搜索树的特性
    // 下面的做法用任意遍历顺序都可以
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
                curr = curr.right;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int val: map.values()) {
            if (val > max) {
                max = val;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == max) {
                list.add(e.getKey());
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (int e: list) {
            res[i++] = e;
        }
        return res;
    }

    // 递归法
    // 记录最大次数
    private int maxCount;
    // 记录当前次数，每个节点都可使用
    private int count;
    // 记录上一个节点
    private TreeNode prev;
    // 存储结果
    private List<Integer> list;

    public int[] findMode2(TreeNode root) {
        maxCount = Integer.MIN_VALUE;
        count = 0;
        prev = null;
        list = new LinkedList<>();

        traversal(root);

        // 将结果放入数组
        int[] res = new int[list.size()];
        int i = 0;
        for (int e: list) {
            res[i++] = e;
        }

        return res;
    }
    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);

        if (prev == null) {
            // 第一个节点，频率记为 1
            count = 1;
        } else if (prev.val == root.val) {
            // 重复的节点，频率 +1
            count++;
        } else {
            // 新节点，频率重置为 1（多个节点公用 count 的关键）
            count = 1;
        }

        // 和当前最大频率相等，放进预结果列表
        if (count == maxCount) {
            list.add(root.val);
        }

        // 频率更大，更新 maxCount，
        // 之前的预结果列表作废，因为有了频率更大的，并将最新的大频率值放进预结果列表
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        }

        prev = root;

        traversal(root.right);
    }
}
