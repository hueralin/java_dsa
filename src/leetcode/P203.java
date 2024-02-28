package leetcode;

import basic.ListNode;

public class P203 {
    public ListNode removeElements(ListNode head, int val) {
        // 如果头节点是要删除的值，那么删除头节点
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 删除中间节点
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    // 带虚拟节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
