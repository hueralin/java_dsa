package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P454 {
    // 暴力
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        for (int a : nums1) {
            for (int b : nums2) {
                for (int c : nums3) {
                    for (int d : nums4) {
                        if (a + b + c + d == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    // 类似于两数之和的做法
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // O(n^2) 统计 a + b 出现的次数
        for (int a: nums1) {
            for (int b: nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        // O(n^2) 从 map 中找 0 - (c + d)
        for (int c: nums3) {
            for (int d: nums4) {
                if (map.containsKey(0 - (c + d))) {
                    count += map.get(0 - (c + d));
                }
            }
        }

        return count;
    }

//    HashMap 存一个数组，如 A。然后计算三个数组之和，如 BCD。时间复杂度为：O(n)+O(n^3)，得到 O(n^3).
//    HashMap 存三个数组之和，如 ABC。然后计算一个数组，如 D。时间复杂度为：O(n^3)+O(n)，得到 O(n^3).
//    HashMap 存两个数组之和，如AB。然后计算两个数组之和，如 CD。时间复杂度为：O(n^2)+O(n^2)，得到 O(n^2).
}
