package leetcode;

import java.util.Arrays;

public class P455 {
    // g: 孩子胃口, s: 饼干尺寸

    // 从小到大排序
    public int findContentChildren(int[] g, int[] s) {
        // 从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 用于遍历孩子胃口
        int i = 0;
        // 用于遍历饼干尺寸
        int j = 0;
        int count = 0;
        // 遍历孩子的胃口和饼干尺寸
        while (i < g.length && j < s.length) {
            // 如果这块饼干的尺寸满足孩子的胃口，则分给他
            if (s[j] >= g[i]) {
                // 遍历下一个孩子
                i++;
                // 遍历下一块饼干
                j++;
                // 满足数 +1
                count++;
            } else {
                // 不满足孩子胃口，则孩子等一等，遍历下一个饼干
                j++;
            }
        }

        return count;
    }

    public int findContentChildren2(int[] g, int[] s) {
        // 从大到小排序（MD，Java 不能这么写，真拉，JS 都可以）
        Arrays.sort(g, (a, b) -> b - a);
        Arrays.sort(s, (a, b) -> b - a);

        // 用于遍历孩子胃口
        int i = 0;
        // 用于遍历饼干尺寸
        int j = 0;
        int count = 0;
        // 遍历孩子的胃口和饼干尺寸
        while (i < g.length && j < s.length) {
            // 如果这块饼干的尺寸满足孩子的胃口，则分给他
            if (s[j] >= g[i]) {
                // 遍历下一个孩子
                i++;
                // 遍历下一块饼干
                j++;
                // 满足数 +1
                count++;
            } else {
                // 不满足孩子胃口，则饼干等一等，遍历下一个孩子
                i++;
            }
        }

        return count;
    }
}
