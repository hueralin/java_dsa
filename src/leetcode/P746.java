package leetcode;

public class P746 {
    int min = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        backtrace(cost, -1, 0);
        return min;
    }
    // sum 是从上一步跳到 i 的花费
    public void backtrace(int[] cost, int i, int sum) {
        if (i >= cost.length) {
            min = Math.min(min, sum);
            return;
        };

        // 从 i 起跳的花费
        int _cost = i == -1 ? 0 : cost[i];
        for (int j = 1; j <= 2; j++) {
            backtrace(cost, i + j, sum + _cost);
        }
    }
    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length < 2) return 0;
        // 定义 dp 数组
        // dp[i] 表示到达第 i 阶所需的最小花费
        int[] dp = new int[cost.length + 1];
        // 因为第 i 层可以从 i - 1 一次跳一下跳过来
        // 也可以从 i - 2 一次跳两下跳过来
        // 因此递推公式为 F(n) = Min(F(n - 1), F(n - 2))
        // 初始化 dp 数组
        dp[0] = 0;
        dp[1] = 0;
        // 从前往后遍历
        for (int i = 2; i <= cost.length; i++) {
            // 跳到 i 的花费等于跳到前一步的花费加上前一步往后跳的花费
            // 即 dp[前] + cost[前]，然后选择花费较小的
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i  -2]);
        }
        return dp[cost.length];
    }
}
