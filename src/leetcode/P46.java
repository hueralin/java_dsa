package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P46 {
    List<List<Integer>> res;
    LinkedList<Integer> path;
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

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
