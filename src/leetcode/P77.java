package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P77 {
    private LinkedList<Integer> path;
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        path = new LinkedList<>();
        res = new LinkedList<>();
        backtrace(n, k, 1);
        return res;
    }

    // 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠 start
    public void backtrace(int n, int k, int start) {
        if (path.size() == k) {
            // 根据已有 list，创建新的 list，如果直接 add(path) 的话，最终都是修改的同一个 path
            res.add(new LinkedList<>(path));
            return;
        }

        // 横向遍历, 从集合中选择元素
        // 优化：i <= n - (k - path.size()) + 1
        for (int i = start; i <= n; i++) {
            // 深入
            path.add(i);
            // 纵向递归
            backtrace(n, k, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
