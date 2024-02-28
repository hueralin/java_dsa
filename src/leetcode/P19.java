package leetcode;

import basic.ListNode;

import java.util.Stack;

public class P19 {
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点，便于操作头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead, fast = dummyHead;
        // fast 先前进 n + 1 步
        // 如果 fast 先前进 n 步，然后 slow, fast 再同时前进的话，结束时，slow 指向被删除的节点，但是没有前置节点，就无法删除
        // 所以让 fast 先前进 n + 1 个节点
        while (n >= 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        // 越界
        if (n >= 0) return dummyHead.next;

        // slow, fast 同时向前移动，直到 fast == null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }

    // 长度计算
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // 第 len - n + 1 就是要删除的节点
        // 从 dummyHead 开始遍历，前进 len - n 步就是要删除的节点的前一个节点
        curr = dummyHead;
        for (int i = 1; i < len - n + 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }

        return dummyHead.next;
    }

    // 栈
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = dummyHead;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // 要删除倒数第几个节点，就从栈中弹出几个，之后的栈顶就是要删除节点的前一个节点
        while (n > 0 && !stack.isEmpty()) {
            stack.pop();
            n--;
        }

        if (!stack.isEmpty()) {
            ListNode prev = stack.peek();
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }

        return dummyHead.next;
    }
}
