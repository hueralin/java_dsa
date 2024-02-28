package leetcode;

import basic.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P160 {
    // Hash 法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            } else {
                curr = curr.next;
            }
        }

        return null;
    }

    // 双指针 1
    // 两个链表遍历两遍
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        // 获取长度差
        int x = lenA > lenB ? lenA - lenB : lenB - lenA;

        // 长链表前进 x 步
        ListNode pA = headA;
        ListNode pB = headB;

        if (lenA > lenB) {
            while (x > 0 && pA != null) {
                pA = pA.next;
                x--;
            }
        } else {
            while (x > 0 && pB != null) {
                pB = pB.next;
                x--;
            }
        }

        // 同时前进
        while (pA != null && pB != null && pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }

    // 双指针 2
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }
}
