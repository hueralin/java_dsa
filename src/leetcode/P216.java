package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P216 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrace(n, k, 1);
        return res;
    }

    public void backtrace(int n, int k, int start) {
        // 优化 1，从和的角度考虑，如果当前的数比较大 n - i 直接干成负数了，那也不用递归了
        if (n < 0) return;

        if (path.size() == k) {
            if (n == 0) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        // 优化 2，从要求的元素个数考虑，取 9 不够 2 个
        for (int i = start; i <= 9 + 1 - k + path.size(); i++) {
        // for (int i = start; i <= 9; i++) {
            n -= i;
            path.add(i);
            backtrace(n, k, i + 1);
            n += i;
            path.removeLast();
        }
    }
}
