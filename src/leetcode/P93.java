package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P93 {
    private List<String> res;
    private LinkedList<String> path;
    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        if (s.isEmpty()) return res;
        path = new LinkedList<>();
        backtrace(s, 0);
        return res;
    }
    public void backtrace(String s, int startIndex) {
        if (path.size() == 4) {
            if (startIndex >= s.length()) {
                String str = String.join(".", path);
                res.add(str);
            }
            return;
        }

        // i < startIndex + 3 剪枝，每次分割的字符串最多三位数
        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            String str = s.substring(startIndex, i + 1);
            // 个位数，或没有前导零的多位数才是合法的数字
            if (str.length() == 1 || str.charAt(0) != '0') {
                double num = Double.parseDouble(str);
                if (num >= 0 && num <= 255) {
                    path.add(str);
                    backtrace(s, i + 1);
                    path.removeLast();
                }
            } else {
                break;
            }
        }

        // 没写出来，想提高下速度
//        for (int i = 0; i < 3; i++) {
//            // 越界
//            if (i + startIndex >= s.length()) return;
//            String str = s.substring(startIndex, startIndex + i + 1);
//            // 切割的字符串长度大于 1，但是有前导零
//            if (i == 0 && str.charAt(0) == '0') return;
//            if (i == 2 && (str.charAt(0) > '2' || str.charAt(1) > '5' || str.charAt(2) > '5')) return;
//            path.add(str);
//            backtrace(s, i + 1);
//            path.removeLast();
//        }
    }
}
