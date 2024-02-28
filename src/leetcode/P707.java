package leetcode;

import basic.ListNode;

public class P707 {
}

class MyLinkedList {
    private final ListNode dummyHead;
    private int size;

    public MyLinkedList() {
        this.dummyHead = new ListNode(0);
        this.size = 0;
    }

    // 获取指定索引的元素
    public int get(int index) {
        // 检查 index 是否合法
        if (index < 0 || index > size - 1) return -1;
        ListNode p = dummyHead.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.val;
    }

    // 在头部插入节点
    public void addAtHead(int val) {
        // 先构造节点
        ListNode node = new ListNode(val);
        node.next = dummyHead.next;
        dummyHead.next = node;
        size++;
    }

    // 在尾部追加节点
    public void addAtTail(int val) {
        // 先构造节点
        ListNode node = new ListNode(val);
        ListNode p = dummyHead;
        // 找到最后一个节点，即 next 为空的节点
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        size++;
    }

    // 在指定索引处插入节点
    public void addAtIndex(int index, int val) {
        // 检查 index 是否合法
        if (index < 0 || index > size) return;
        // 构造节点
        ListNode node = new ListNode(val);

        ListNode p = dummyHead;
        while (index > 0) {
            p = p.next;
            index--;
        }

        node.next = p.next;
        p.next = node;
        size++;
    }

    // 在指定索引处删除节点
    public void deleteAtIndex(int index) {
        // 检查 index 是否合法
        if (index < 0 || index > size - 1) return;

        ListNode p = dummyHead;
        while (index > 0) {
            p = p.next;
            index--;
        }

        p.next = p.next.next;
        size--;
    }
}
