package leetcode;

import java.util.Arrays;

public class P1005 {
    // 暴力回溯
    int max = Integer.MIN_VALUE;
    public int largestSumAfterKNegations(int[] nums, int k) {
        backtrace(nums, k);
        return max;
    }
    public void backtrace(int[] nums, int k) {
        if (k == 0) {
            int sum = 0;
            for (int n: nums) {
                sum += n;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
            backtrace(nums, k - 1);
            nums[i] = -nums[i];
        }
    }

    // 先排序，再反转
    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 先将负数变正
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }

        Arrays.sort(nums);

        if (k % 2 != 0) {
            nums[0] = -nums[0];
        }

        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        return sum;
    }
}
