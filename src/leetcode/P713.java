package leetcode;

public class P713 {
    // 暴力破解
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int mul = 1;
            for (int j = i; j < nums.length; j++) {
                mul *= nums[j];
                if (mul < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left = 0, right = 0, mul = 1, count = 0;

        while (right < nums.length) {
            mul *= nums[right];

            while (left <= right && mul >= k) {
                mul /= nums[left];
                left++;
            }

            count += (right - left + 1);

            right++;
        }

        return count;
    }
}
