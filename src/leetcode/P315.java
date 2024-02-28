package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P315 {
    // 毫无疑问，超时了
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(0);
        }
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < curr) {
                    res.set(i, res.get(i) + 1);
                }
            }
        }
        return res;
    }
}
