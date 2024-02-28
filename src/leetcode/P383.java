package leetcode;

public class P383 {
    // 哈希法
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];

        if (ransomNote.length() > magazine.length()) return false;

        // 统计杂志中每个字符出现的次数
        for (char c: magazine.toCharArray()) {
            records[c - 'a']++;
        }

        // 查看信中字符是否记录在案，如果有就减去一次
        for (char c: ransomNote.toCharArray()) {
            records[c - 'a']--;
            // 如果某个字符在案的次数小于 0，说明杂志中的字符不够，所以不满足
            if (records[c - 'a'] < 0) return false;
        }

        return true;
    }

    // 其实也可以统计信中的字符
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] records = new int[26];

        if (ransomNote.length() > magazine.length()) return false;

        // 统计信中各字符出现的次数
        for (char c: ransomNote.toCharArray()) {
            records[c - 'a']++;
        }

        for (char c: magazine.toCharArray()) {
            records[c - 'a']--;
            // 不能在这里判断退出，因为 magazine 还没还没遍历完呢，不能及时退出
            // if (records[c - 'a'] > 0) return false;
        }

        for (int cnt: records) {
            // 某些字符的数量还大于 0，说明 magazine 中的该字符数量不够
            if (cnt > 0) return false;
        }

        return true;
    }
}
