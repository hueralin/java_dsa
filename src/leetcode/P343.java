package leetcode;

public class P343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            // 拆分成 j 和 i - j，dp[i] 可以直接取 j * (i - j)，
            // 也可以取 j * dp(i - j)，哪个大取哪个
            // 然后遍历 j，每次都得到一个 dp[i]，取最大的那个
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
