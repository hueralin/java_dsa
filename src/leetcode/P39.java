package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P39 {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrace(candidates, target, 0);
        return res;
    }
    public void backtrace(int[] candidates, int target, int startIndex) {
        // 下面有优化，这里就不需要了
        // if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 优化手段：已知当前数值相加会大于 target，就没必要进入下一次递归了（虽然下一次递归会立刻返回）
            if (target - candidates[i] < 0) continue;
            path.add(candidates[i]);
            // 这里继续传 i 是因为题目要求 path 中可以有重复的元素
            backtrace(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}
