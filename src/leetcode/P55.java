package leetcode;

public class P55 {
    // 暴力回溯
    boolean ok = false;
    public boolean canJump(int[] nums) {
        backtrace(nums, 0);
        return ok;
    }

    /**
     *
     * @param nums 数组
     * @param index 到达的位置
     */
    public void backtrace(int[] nums, int index) {
        if (index >= nums.length) return;
        if (index == nums.length - 1) {
            // 能访问到最后一个元素
            ok = true;
            return;
        }

        for (int i = 1; i <= nums[index]; i++) {
            // 剪枝
            if (ok) return;
            backtrace(nums, index + i);
        }
    }

    // 贪心
    public boolean canJump2(int[] nums) {
        // 当前最远到达的位置
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // i 超出了最远到达的位置，说明 i 不可达
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) return true;
        }
        return false;
    }
}
