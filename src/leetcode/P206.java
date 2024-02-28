package leetcode;

import basic.ListNode;

public class P206 {
    // 头插法
    public ListNode reverseList(ListNode head) {
        // 新建一个空链表
        ListNode dummyHead = new ListNode(0);

        ListNode curr = head;
        while (curr != null) {
            // 先存储当前节点的下一个节点
            ListNode next = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next = curr;
            // 遍历下一个节点
            curr = next;
        }

        return dummyHead.next;
    }

    // 双指针法
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            // 先保存当前遍历节点的下一个节点
            ListNode next = head.next;
            // 让当前遍历节点的指针逆置
            head.next = pre;
            // pre 前进
            pre = head;
            // 当前遍历节点前进
            head = next;
        }

        return pre;
    }

    // 递归解法 - 还是双指针的思想
    public ListNode reverseList3(ListNode head) {
        return reverse(head, null);
    }

    // 逆置当前节点
    public ListNode reverse(ListNode curr, ListNode pre) {
        if (curr == null) return pre;
        // 保存下一个要访问的节点
        ListNode next = curr.next;
        // 当前访问节点的指针逆置
        curr.next = pre;
        // 逆置下一个要访问的节点
        return reverse(next, curr);
    }
}
