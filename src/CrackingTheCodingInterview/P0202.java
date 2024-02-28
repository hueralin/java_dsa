package CrackingTheCodingInterview;

import basic.ListNode;

public class P0202 {
    public int kthToLast(ListNode head, int k) {
        // 题目说保证 k 是有效的，所以这个判断可以没有
        if (head == null || k <= 0) return -1;
        ListNode slow = head, fast = head;

        // k - 1 是链表末尾到倒数第 k 个节点的距离
        // k 是 null 到倒数第 k 个节点的距离
        for (int i = 0; i < k - 1; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // k 过大，越界，题目说保证 k 是有效的，所以这个判断可以没有
                return -1;
            }
        }

        // 走 k - 1 步，因此循环终止于尾节点
        // 如果走 k 步，则循环终止于 null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
