package leetcode;

public class P45 {
    // 暴力回归
    int minCount;
    public int jump(int[] nums) {
        minCount = nums.length - 1;
        backtrace(nums, 0, 0);
        return minCount;
    }
    public void backtrace(int[] nums, int index, int currCount) {
        if (index >= nums.length) return;
        if (index == nums.length - 1) {
            minCount = Math.min(minCount, currCount);
            return;
        }

        for (int i = 1; i <= nums[index]; i++) {
            backtrace(nums, index + i, currCount + 1);
        }
    }

    // 贪心
    public int jump2(int[] nums) {
        int end = 0;
        int maxIndex = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 当前节点最远可以到达的边界
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }

        return step;
    }
}
