package leetcode;

public class P70 {
    // 超时
    int count = 0;
    public int climbStairs(int n) {
        backtrace(n);
        return count;
    }
    public void backtrace(int n) {
        if (n < 0) return;
        if (n == 0) {
            count++;
            return;
        }

        backtrace(n - 1);
        backtrace(n - 2);
    }
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        // 定义 dp 数组
        // dp[i] 表示到达第 i 阶有 dp[i] 种解法
        int[] dp = new int[n + 1];
        // 根据决策图，得递推公式 F(n) = F(n - 1) + F(n - 2)
        // 初始化，到达第一阶有一种解法，到达第二阶有两种解法
        dp[1] = 1;
        dp[2] = 2;
        // 根据递推公式，知道到达第 i 阶的解法和前两阶有关，所以从前往后遍历，构建 dp 数组
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
