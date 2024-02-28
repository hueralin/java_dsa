package leetcode;

import java.util.Set;
import java.util.HashSet;

public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 根据题目要求，数组里的元素不超过 1000，所以可以使用数组来代替 Hash 表
        // 如果不知道数组元素的范围，那么最好使用哈希表
        int[] arr = new int[1001];
        Set<Integer> set = new HashSet<>();

        for (int num: nums1) {
            arr[num] = 1;
        }

        for (int num: nums2) {
            if (arr[num] == 1) {
                set.add(num);
            }
        }

        int[] res = new int[set.size()];

        int i = 0;
        for (int num: set) {
            res[i++] = num;
        }

        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) {
            set1.add(num);
        }

        for (int num: nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (int num: set2) {
            res[i++] = num;
        }

        return res;
    }
}
