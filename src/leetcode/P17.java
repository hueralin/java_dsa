package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P17 {
    private List<String> res;
    private LinkedList<Character> path;
    private Map<Character, char[]> map;
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        path = new LinkedList<>();
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        backtrace(digits, 0);
        return res;
    }

    public void backtrace(String digits, int startIndex) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c: path) sb.append(c);
            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(startIndex);
        char[] arr = map.get(digit);
        for (char elem: arr) {
            path.add(elem);
            // 这里的 startIndex + 1 实际上控制的是对 digits 的访问，对 digits 中的下一个数字对应的 “字母集合” 的访问
            // 并不是对本 “字母集合”（arr）的访问
            backtrace(digits, startIndex + 1);
            path.removeLast();
        }
    }
}
