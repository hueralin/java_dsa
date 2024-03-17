package leetcode;

public class P509 {
    public int fib(int n) {
        // 当 n 是 0、1 时的解
        if (n <= 1) return n;
        // 定义 dp 数组，保存递推的结果
        // dp[i] 表示第 i 个斐波那契数
        // 因为数列有第 0 个数，所以 dp 数组长度为 n + 1
        int[] dp = new int[n + 1];
        // 题目给出了递推公式: F(n) = F(n - 1) + F(n - 2)
        // 初始化 dp 数组
        dp[0] = 0;
        dp[1] = 1;
        // 根据递推公式可知当前的斐波那契数是前两个数相加得到的
        // 因此可以确定 dp 数组的遍历顺序，从前往后
        for (int i = 2; i <= n; i++) {
            // 根据递推公式求解
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public int fib3(int n) {
        if (n < 2) return n;
        return fib3(n - 1) + fib3(n - 2);
    }
}
