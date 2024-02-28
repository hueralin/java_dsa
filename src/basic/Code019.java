package basic;

import java.util.Scanner;
import java.util.Stack;

public class Code019 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(sc.nextInt());
            n--;
        }
        int m = sc.nextInt();
        while (m > 0) {
            int op = sc.nextInt();
            if (op == 1 && !stack.isEmpty()) {
                // 弹出栈时要检查栈是否为空
                stack.pop();
            } else if (op == 2) {
                stack.push(sc.nextInt());
            }
            m--;
        }
        if (stack.isEmpty()) {
            System.out.println("All the dishes have been washed.");
        } else {
            System.out.println(stack.peek());
        }
        sc.close();
    }
}
