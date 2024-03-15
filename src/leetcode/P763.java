package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();

        // 记录每个字符最远出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) > end) {
                end = map.get(c);
            }
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }

        return res;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> res = new LinkedList<>();

        // 记录每个字符最远出现的位置
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] > end) {
                end = map[c - 'a'];
            }
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
