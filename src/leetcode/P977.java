package leetcode;

public class P977 {
    // 暴力破解算法是先平方，再排序

    // 双指针
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int k = len - 1;
        // 双指针
        int i = 0, j = len - 1;

        while (i <= j) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];

            if (i2 > j2) {
                res[k--] = i2;
                i++;
            } else {
                res[k--] = j2;
                j--;
            }
        }

        return res;
    }
}
