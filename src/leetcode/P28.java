package leetcode;

import java.util.Arrays;

public class P28 {
    public static int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
    }

    // next 数组，next[i] 表示 i 及其之前的字符组成的字符串中最长的相同前后缀的长度
    public static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        char[] arr = needle.toCharArray();

        int i = 0, j = i + 1;
        next[0] = 0;
        while (j < arr.length) {
            if (arr[j] == arr[i]) {
                next[j] = i + 1;
                i++;
                j++;
            } else {
                // 重点
                i = next[i - 1];
                if (arr[j] == arr[i]) {
                    next[j] = i + 1;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
        }

        return next;
    }
}
