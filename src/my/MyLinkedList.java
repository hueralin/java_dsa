package my;

public class MyLinkedList<E> {
    private static class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;

        public Node(E val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private final Node<E> head;
    private final Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 增
    public void addFirst(E elem) {
        Node<E> node = new Node<>(elem);
        // 先处理新节点的前后连接
        node.prev = head;
        node.next = head.next;
        // 再处理前后节点的连接
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void addLast(E elem) {
        Node<E> node = new Node<>(elem);
        // 先处理新节点的前后连接
        node.prev = tail.prev;
        node.next = tail;
        // 再处理前后节点的连接
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // 工具函数
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public boolean isPositionIndex(int index) {
        return index >= 0 && index < size;
    }
}
