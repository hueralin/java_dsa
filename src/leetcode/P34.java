package leetcode;

public class P34 {
    // 暴力破解，O(n)，记录第一次出现的下标和最后一次出现的下标
    public int[] searchRange(int[] nums, int target) {
        int left = -1;
        int right = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            } else if (right != -1) {
                break;
            }
        }

        return new int[]{left, right};
    }

    public int[] searchRange2(int[] nums, int target) {
        int first = -1;
        int last = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                first = mid;
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                last = mid;
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
