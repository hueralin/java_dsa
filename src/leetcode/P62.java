package leetcode;

public class P62 {
    int count = 0;
    public int uniquePaths(int m, int n) {
        backtrace(m, n, 0, 0);
        return count;
    }
    public void backtrace(int m, int n, int i, int j) {
        // 越界
        if (i >= m || j >= n) return;
        // 到达右下角
        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }
        for (int k = 1; k <= 2; k++) {
            backtrace(m, n, k == 1 ? i + 1 : i, k == 1 ? j : j + 1);
        }
    }
    public int uniquePaths2(int m, int n) {
        // dp[i][j] 表示到达 i,j 位置有几种解法
        int[][] dp = new int[m][n];
        // 因为机器人在左上角，目的地在右下角
        // 并且机器人只能往右或往下走
        // 所以到达 i,j 的方向有两个：[i, j - 1] 和 [i - 1, j]
        // 因此状态转移方程: F(i, j) = F(i, j - 1) + F(i - 1, j)
        // 初始化 dp
        dp[0][0] = 1;
        // 遍历 dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        // dp 初始化，第一行以及第一列初始化为 1
        // 因为这两个部分的值无法直接从递推公式计算
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 遍历 dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
