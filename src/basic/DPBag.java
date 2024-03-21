package basic;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 物品的数量
        int m = sc.nextInt();
        // 背包的容量
        int n = sc.nextInt();
        // 物品重量数组
        int[] spaces = new int[m];
        // 物品价值数组
        int[] values = new int[m];

        for (int i = 0; i < m; i++) {
            spaces[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            values[i] = sc.nextInt();
        }

        // backtrace(spaces, values, m, n, 0, 0);

        int max = dpSolution(spaces, values, m, n);
        System.out.println(max);

        sc.close();
    }

    // 暴力回溯
    public static int maxValue = 0;
    public static void backtrace(int[] spaces, int[] values, int m, int n, int idx, int val) {
        if (idx == m || n == 0) {
            maxValue = Math.max(maxValue, val);
            return;
        }

        for (int i = idx; i < m; i++) {
            if (n - spaces[i] >= 0) {
                backtrace(spaces, values, m, n - spaces[i], i + 1, val + values[i]);
            }
        }
    }

    // 动态规划
    public static int dpSolution(int[] spaces, int[] values, int m, int n) {
        // dp[i][j] 表示从 0 ~ i 个物品中选择，在背包容量为 j 时的最大价值
        int[][] dp = new int[m][n + 1];
        // 递推公式，dp[i][j]，容量为 j 时，
        // 在当前物品可选的情况下的价值（当前物品的价值和剩余容量的最大价值）v[i] + dp[i-1][j-当前物品的重量] (dp[i-1[j-w[i]])
        // 和
        // 当前物品不可选的情况下的价值，即 dp[i-1][j]
        // 谁更大。

        // 初始化，根据递推公式可知，我们要往左上角查找，所以要把第一列和第一行初始化
        // 初始化第一列为 0，默认都是 0
        // 初始化第一行
        for (int j = 0; j < dp[0].length; j++) {
            // 第一行只能选第一个物品
            if (spaces[0] <= j) {
                dp[0][j] = values[0];
            }
        }

        // 遍历，按行遍历，从小背包开始，用小问题的解解决大问题
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (spaces[i] <= j) {
                    // 放得下 i，但要考虑放与不放哪个价值大
                    dp[i][j] = Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - spaces[i]]);
                } else {
                    // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n];
    }
}
