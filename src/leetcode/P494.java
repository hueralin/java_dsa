package leetcode;

import java.util.Arrays;

public class P494 {
    // 回溯法，竟然过了？
    public int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        backtrace(nums, target, res, 0, 0);
        return res[0];
    }
    public void backtrace(int[] nums, int target, int[] res, int sum, int start) {
        if (start == nums.length) {
            if (sum == target) {
                res[0]++;
            }
            return;
        }

        backtrace(nums, target, res, sum + nums[start],start + 1);
        backtrace(nums, target, res, sum - nums[start],start + 1);
    }

    // 动态规划
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum + target < 0) return 0;
        if ((sum + target) % 2 != 0) return 0;
        int positive = (sum + target) / 2;

        // dp[i][j] 表示从 0 ~ i 中选择数字，使其和等于 j 的组合数
        int[][] dp = new int[nums.length + 1][positive + 1];
        // 初始化
        dp[0][0] = 1;
        // 遍历
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= positive; j++) {
                if (num <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int[] x: dp) {
            System.out.println(Arrays.toString(x));
        }

        return dp[nums.length][positive];
    }
}
