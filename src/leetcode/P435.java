package leetcode;

import java.util.Arrays;

public class P435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int end = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < end) {
                result++;
                // 为什么要取较小的作为边界
                // 这就是我们贪心的思路，取最小的就意味着删掉交叉、但右边界较大的区间
                // 这样可以减少较大区间对后续区间交叉的概率
                // 即删除交叉区间中较长（右边界较大）的那一个，减少对后续区间的影响
                end = Math.min(end, curr[1]);
            } else {
                end = curr[1];
            }
        }

        return result;
    }
}
