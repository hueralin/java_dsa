package kama;

import java.util.Scanner;

public class T46Bag {
    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 物品数量
        int m = sc.nextInt();
        // 背包容量
        int n = sc.nextInt();
        // 物品重量
        int[] weights = new int[m];
        // 物品价值
        int[] values = new int[m];

        // 初始化物品重量
        for (int i = 0; i < m; i++) {
            weights[i] = sc.nextInt();
        }
        // 初始化物品价值
        for (int i = 0; i < m; i++) {
            values[i] = sc.nextInt();
        }

        int maxValue = dpSolution(weights, values, m, n);

        System.out.println(maxValue);

        sc.close();
    }

    public static int dpSolution(int[] weights, int[] values, int m, int n) {
        // dp[i][j] 表示从 0 ~ i 个物品中选择，在容量限制为 j 的情况下能装取的最大收益
        int[][] dp = new int[m][n + 1];

        // 初始化 dp
        // 容量为 0，价值为 0（第一列）
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        // 只能选第一件物品时最大价值取决于第一件物品的重量
        for (int j = 1; j <= n; j++) {
            dp[0][j] = weights[0] <= j ? values[0] : 0;
        }

        // 开始递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - weights[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n];
    }

    public static int dpSolution2(int[] weights, int[] values, int m, int n) {
        // dp[j] 表示容量为 j 的背包，能获得的最大价值
        int[] dp = new int[n + 1];

        // 初始化
        // 容量为 0 时当然初始化为 0
        dp[0] = 0;
        // 容量不为 0 时，看递推公式，dp[j] 要和其他值做比较取最大
        // 所以也初始化为 0，免得初始值大了，会覆盖本要求得的值

        // 遍历
        for (int i = 0; i < m; i++) {
            // 背包要倒序遍历，正序遍历会出现物品被多次选择的情况
            for (int j = n; j > 0; j--) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }

        return dp[n];
    }
}
