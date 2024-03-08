package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P491 {
    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrace(nums, 0);
        return res;
    }
    public void backtrace(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new LinkedList<>(path));
            // 这里不能 return，还要继续向下找
        }

        // 题目给出了 nums 中数字的范围是 [-100, 100]，所以声明一个 201 大小的数组
        // 记录某个数字在本层是否使用过
        boolean[] used = new boolean[201];
        for (int i = startIndex; i < nums.length; i++) {
            // 因为题目给的数组不是有序的，因此不能用此技巧
            // 并且题目要求根据原数组的顺序获得非递减的序列，所以我们也不能排序
            // if (i > startIndex && nums[i] == nums[i - 1]) continue;

            // 如果 path 不为空，但是当前元素小于上一个元素，说明失序，就不能继续深入
            // 或者当前元素在本层已经被使用过，那也不能继续了，因为要求结果不能重复
            // nums[i] + 100 是因为数组没有负下标，所以往前移一下，
            // 即 nums[i] == -100，在 used 中用 0 下标表示，nums[i] == 100，在 used 中用 100 下标表示
            // 也算个技巧吧
            if ((!path.isEmpty() && nums[i] < path.getLast()) || used[nums[i] + 100]) continue;

            used[nums[i] + 100] = true;
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.removeLast();
            // 这里 used 不需要回溯，因为 used 只负责本层，下层有自己的 used
            // 用过的元素设置为 true 就行，不用改回 false，否则就不起到去重的效果了
        }
    }
}
