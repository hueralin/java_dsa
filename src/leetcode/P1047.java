package leetcode;

import java.util.Stack;

public class P1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (c == top) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        char[] tmp = new char[stack.size()];
        int i = 0, j = tmp.length - 1;
        while (!stack.isEmpty()) {
            tmp[i++] = stack.pop();
        }

        i = 0;
        for (; i < j; i++, j--) {
            char t = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = t;
        }

        return new String(tmp);
    }
}
