package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class P56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= end) {
                // 重叠，合并，只用更新右边界，即取较大的 end
                end = Math.max(end, curr[1]);
            } else {
                // 不重叠，收集结果，然后记录新的 start、end
                list.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
        }

        // 加上最后一个区间
        list.add(new int[]{start, end});

//        int[][] res = new int[list.size()][];
//        int i = 0;
//        for (int[] e: list) {
//            res[i++] = e;
//        }
//        return res;
        return list.toArray(new int[list.size()][]);
    }
}
