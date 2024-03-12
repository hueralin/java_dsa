package leetcode;

public class P122 {
    // 暴力回溯
    int max = 0;
    public int maxProfit(int[] prices) {
        backtrace(prices, 0, 0, 0);
        return max;
    }

    /**
     *
     * @param prices 股价表
     * @param status 持有状态，0 未持有，1 持有
     * @param currProfit 当前利润
     * @param day 天数
     */
    public void backtrace(int[] prices, int status, int currProfit, int day) {
        if (day == prices.length) {
            // 决策树到头了，开始统计结果
            if (currProfit > max) {
                max = currProfit;
            }
            return;
        }

        // 不操作
        backtrace(prices, status, currProfit, day + 1);
        // 操作
        if (status == 0) {
            // 买入
            backtrace(prices, 1, currProfit - prices[day], day + 1);
        } else {
            // 卖出
            backtrace(prices, 0, currProfit + prices[day], day + 1);
        }
    }

    // 贪心算法
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
