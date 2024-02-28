package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1 {
    // 暴力
    public int[] twoSum(int[] nums, int target) {
        // 遍历数组元素 a
        for (int i = 0; i < nums.length; i++) {
            // 从剩余的数组元素中找满足 a + b = t 的 b，即查找 t - a 元素，即 t - a 在不在剩余数组中
            // 这个找的过程费时，是优化的方向
            // 可不可以空间换时间？将 O(n) 的查找变成 O(1)？
            // 哈希表？
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        // 存储遍历过的元素和下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果 t - a 在 map 中，则返回
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                // 如果不在，则将当前访问的元素及其下标放入 map
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
