package leetcode;

public class P209 {
    // 暴力
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, (j - i + 1));
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
