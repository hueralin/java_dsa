package leetcode;

import java.util.LinkedList;

public class P300 {
    // 暴力回溯，超时
    private int max = 0;
    public int lengthOfLIS(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrace(nums, 0, path);
        return max;
    }
    public void backtrace(int[] nums, int start, LinkedList<Integer> path) {
        // 先更新最大值，即要在每一次选择值后更新
        max = Math.max(max, path.size());
        if (start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (path.isEmpty() || nums[i] > path.getLast()) {
                path.add(nums[i]);
                backtrace(nums, i + 1, path);
                path.removeLast();
            }
        }
    }
}
