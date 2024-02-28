package leetcode;
import java.util.Stack;

public class P232 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public P232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int top = stack2.peek();
        return top;
    }

    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}
