package leetcode;

import java.util.Arrays;

public class P1049 {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1) return stones[0];
        int sum = 0;
        for (int s: stones) {
            sum += s;
        }
        int target = sum / 2;

        int[] dp = new int[target + 1];
        // 初始化，其余也是 0
        dp[0] = 0;

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j > 0; j--) {
                if (stones[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        int x = sum - dp[target];
        return Math.abs(x - dp[target]);
    }
}
