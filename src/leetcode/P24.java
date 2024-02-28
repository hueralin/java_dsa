package leetcode;

import basic.ListNode;

public class P24 {
    // 迭代法
    public ListNode swapPairs(ListNode head) {
        // 定义虚拟头节点，方便操作头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 因为要操作 A、B 的交换，所以要从 A 的前一个节点开始，于是从虚拟头节点遍历
        ListNode curr = dummyHead;

        // 因为要操作 A、B 的交换，所以要从 A 的前一个节点开始，
        // 对于偶数个节点来说，curr 最终位于最后一个节点，所以 curr.next 为 null 时退出
        // 对于奇数个节点来说，curr 最终位于倒数第二个节点，所以 curr.next.next 为 null 时退出
        while (curr.next != null && curr.next.next != null) {
            ListNode t1 = curr.next;
            ListNode t2 = curr.next.next.next;

            curr.next = curr.next.next;
            curr.next.next = t1;
            t1.next = t2;

            curr = curr.next.next;
        }

        return dummyHead.next;
    }
}
