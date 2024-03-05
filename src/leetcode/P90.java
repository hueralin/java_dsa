package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P90 {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(nums, 0);
        return res;
    }
    public void backtrace(int[] nums, int startIndex) {
        res.add(new LinkedList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            // 和前面的元素相同，就不处理了，试探下一个
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
        }
    }
}
