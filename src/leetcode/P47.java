package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        // 去重一定要对元素进行排序，这样我们才方便通过相邻的节点来判断是否重复使用了
        Arrays.sort(nums);
        backtrace(nums);
        return res;
    }
    public void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 重点
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue;
            path.add(nums[i]);
            backtrace(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
