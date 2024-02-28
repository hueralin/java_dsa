package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P225 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public P225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 模拟栈，即先把 queue1 腾至 queue2，把新元素放进去，再把旧元素放回去
    public void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.remove());
        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int peek() {
        return queue1.remove();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
