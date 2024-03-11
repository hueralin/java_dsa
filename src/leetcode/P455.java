package leetcode;

import java.util.Arrays;

public class P455 {
    // 遍历孩子，孩子能吃就吃
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1;
        int j = s.length - 1;
        int res = 0;

        // 同时从后开始遍历
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                // 如果当前饼干的 size 满足小孩的胃口，则把这个饼干给这个小孩
                res++;
                // 尝试下一个饼干
                j--;
            }
            // 不管当前饼干满不满足这个小孩的胃口，接下来都要尝试下一个小孩
            i--;
        }

        return res;
    }

    // 遍历饼干，饼干能给就给
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res++;
                i++;
            }
            j++;
        }

        return res;
    }
}
