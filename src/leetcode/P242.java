package leetcode;

public class P242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // 存储 s 中各个小写字母出现的次数
        int[] records = new int[26];

        // 记录 s 中各个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            records[idx]++;
        }

        // 遍历 t 中出现的各个字符，出现，就将 records 对应字符的次数 -1
        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            records[idx]--;
        }

        // 如果 records 中的值均为 0，说明 t 中的字符和 s 中正好一样，且次数相等
        for (int record : records) {
            if (record != 0) return false;
        }

        return true;
    }
}
