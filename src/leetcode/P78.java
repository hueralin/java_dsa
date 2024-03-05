package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P78 {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrace(nums, 0);
        return res;
    }
    public void backtrace(int[] nums, int startIndex) {
        res.add(new LinkedList<>(path));

        // 可以不加，因为下面的 for 也不会执行了
        // if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
        }
    }
}
