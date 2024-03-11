package leetcode;

public class P53 {
    // 暴力，会超时
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }
            // 如果连续和已经小于 0 了，那么再往后累加都是在 “减小”
            // 所以重新计算累加和
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
