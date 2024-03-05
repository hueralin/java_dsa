package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P40 {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        // 去重的关键 1
        // 剪枝的关键
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }
    public void backtrace(int[] candidates, int target, int startIndex) {
        // 有剪枝，所以这里不要了
        // if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 剪枝
        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            // 去重的关键 2
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
