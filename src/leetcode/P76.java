package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            // 扩大窗口
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 缩小窗口
            while (valid == need.size()) {
                // 满足条件，记录一个解
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char cc = s.charAt(left);
                left++;

                if (need.containsKey(cc)) {
                    if (window.get(cc).equals(need.get(cc))) {
                        valid--;
                    }
                    window.put(cc, window.get(cc) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
