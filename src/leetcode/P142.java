package leetcode;

import basic.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P142 {
    // Hash 存储节点，如果存在，说明遍历到了环入口处
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            } else {
                set.add(curr);
            }
            curr = curr.next;
        }

        return null;
    }

    // 双指针
}
