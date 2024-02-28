package leetcode;

import basic.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P141 {
    // Set 做法
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            if (set.contains(p)) {
                return true;
            } else {
                set.add(p);
            }
            p = p.next;
        }

        return false;
    }

    // 快慢指针
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;

        // 如果没有环，则 fast 会率先到达 null，循环退出
        // 如果有环，则 fast、slow 都会进入环，就像是操场跑步，一定会遇到。
        // 但为什么是 fast == slow，而不是 fast 一步跨过去呢，然后一直错过？
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
