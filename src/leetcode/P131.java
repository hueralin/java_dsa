package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P131 {
    private List<List<String>> res;
    private LinkedList<String> path;
    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        backtrace(s, 0);
        return res;
    }
    public void backtrace(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (isPalindrome(str)) {
                path.add(str);
                backtrace(s, i + 1);
                path.removeLast();
            }
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
