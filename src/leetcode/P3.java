package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char curr = s.charAt(right);
            window.put(curr, window.getOrDefault(curr, 0) + 1);

            // 这里这么判断实际上是取决于 window 是干啥的，以及在这之前的操作
            // 缩小窗口，直到窗口内没有重复字符，这才算是一个解（无重复字符的子串）
            while (window.get(curr) > 1) {
                char old = s.charAt(left);
                if (window.get(old) > 1) {
                    window.put(old, window.get(old) - 1);
                } else {
                    window.remove(old);
                }
                left++;
            }

            // 更新答案
            // 判断这个解是否为最优解
            if (window.size() > maxLen) {
                maxLen = window.size();
            }

            // 扩大窗口
            right++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    // 推荐这个
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);

            // 缩小窗口，直到窗口内不再包含重复的 ch 字符
            while (window.contains(ch)) {
                // 这一步是优化点
                char old = s.charAt(left);
                window.remove(old);
                left++;
            }

            // 再把 ch 放进去
            window.add(ch);

            // 更新最优解
            maxLen = Math.max(maxLen, right - left + 1);

            // 扩大窗口
            right++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (window.containsKey(ch)) {
                // 确保 left 不会回退，根本原因是 left 跳跃后, window 中 left 之前的字符索引没有被清除
                left = Math.max(left, window.get(ch) + 1);
            }

            window.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
