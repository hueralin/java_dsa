package leetcode;

public class P704 {
    // T: O(logn)
    // S: O(1)
    // target 的查找区间是 [left, right]
    public int search(int[] nums, int target) {
        // 如果 target 小于最小值，或者大于最大值，则直接返回 -1，避免不必要的循环
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        int left = 0;
        int right = nums.length - 1;
        // 因为查找区间是 [left, right]，所以 left == right 是有意义的，
        // 表示数组只有一个值的情况，所以写 <=
        while (left <= right) {
            // 下面的写法虽然和 (left + right) / 2 一样，但是在面临 left、right 非常大（可能会溢出的场景下）是很有用的。
            // int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // target 的查找区间是 [left, right)
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 因为查找区间是 [left, right)，即不会在 right 上查找值，
        // 所以 left == right 是没意义的，因此写 <
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                // 因为 right 代表的是不会被查找的值
                // 并且你确定 mid 上不是你要的值，但 mid - 1 可能是，
                // 所以 right 不能等于 mid - 1，而等于 mid
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
