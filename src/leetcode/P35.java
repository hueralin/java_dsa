package leetcode;

public class P35 {
    // T: O(logn)
    // S: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    // 左闭右开区间
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // 画图可知为何是 right
        // 另一种描述，right 不在搜索区间内，反过来讲 nums[right] 不会是 target,
        // 所以当搜索空间为空时，如果要插入的话，就只能在这个位置插入
        return right;
    }

    // T: O(n)
    // S: O(1)
    public int searchInsert3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 如果在 i 处大于 target，说明 i 之前都小于 target，所以此处是插入的位置
            // 如果 nums[i] == target，直接返回就是了
            if (nums[i] >= target) {
                return i;
            }
        }
        // 遍历完了都没返回，说明插在最后
        return nums.length;
    }
}
