package leetcode;

import java.util.Arrays;

public class P452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 注意这里的减法，可能会溢出，参考用例 [[-2147483646,-2147483645],[2147483646,2147483647]]
        // Arrays.sort(points, (int[] a, int[] b) -> a[0] - b[0]);
        // 改为，可以按左边界排序，下面就正向循环，也可以按右边界排序，下面就反向循环
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = points[0][1];
        int arrowCount = 1;

        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] > prevEnd) {
                // 不相交
                arrowCount++;
                prevEnd = curr[1];
            } else {
                // 取较小值更新右边界，想要尽纳容纳更多的气球，就要看短板
                prevEnd = Math.min(prevEnd, curr[1]);
            }
        }

        return arrowCount;
    }
}
