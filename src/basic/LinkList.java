package basic;

public class LinkList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // 头指针
    private int length;

    public LinkList() {
        this.head = null;
        this.length = 0;
    }

    public Node insert(int data) {
        this.length++;
        Node node = new Node(data);

        if (this.head == null) {
            this.head = node;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }

        return node;
    }

    public Node insert(int pos, int data) {
        if (pos <= 0) return null;

        if (pos == 1) {
            Node node = new Node(data);
            node.next = this.head;
            this.head = node;
            return node;
        }

        int i = 1;
        Node prev = null;
        Node curr = this.head;

        while (curr != null && i < pos) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr == null) return null;

        Node node = new Node(data);
        node.next = curr;
        prev.next = node;
        return node;
    }

    public Node get(int pos) {
        if (pos <= 0) return null;

        int i = 1;
        Node curr = this.head;

        while (curr != null && i < pos) {
            curr = curr.next;
            i++;
        }

        return curr;
    }

    public Node delete(int pos) {
        if (pos <= 0 || this.length == 0) return null;

        if (pos == 1) {
            Node delNode = this.head;
            this.head = delNode.next;
            delNode.next = null;
            this.length--;
            return delNode;
        }

        Node prev = null;
        Node curr = this.head;
        int i = 1;

        while (curr != null && i < pos) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr == null) return null;

        prev.next = curr.next;
        curr.next = null;
        this.length--;
        return curr;
    }

    public void print() {
        Node curr = this.head;
        while (curr != null) {
            System.out.printf("%d%c", curr.data, curr.next == null ? '\n' : ' ');
            curr = curr.next;
        }
    }
}
