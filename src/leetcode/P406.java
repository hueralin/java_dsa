package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class P406 {
    public int[][] reconstructQueue(int[][] people) {
        // 先按身高降序排序，如果身高相等，就按 k 的升序排列
        Arrays.sort(people, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        // 再按 k 插入到列表中
        for (int[] person : people) {
            int idx = person[1];
            list.add(idx, person);
        }
        // 将结果转为二维数组
        int[][] res = new int[list.size()][];
        int i = 0;
        for (int[] e: list) {
            res[i++] = e;
        }
        return res;
    }
}
