package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P46 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    // 记录此时 path 里都有哪些元素使用了，一个排列里一个元素只能使用一次
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        used = new boolean[nums.length];
        backtrace(nums);
        return res;
    }

    public void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 因为是全排列，所以 i 要从头开始遍历，只是同一 path 中不能有重复的元素
        for (int i = 0; i < nums.length; i++) {
            // 通过全局 used 保证同一条 path 中没有重复的元素
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
