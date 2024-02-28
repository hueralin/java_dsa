package my;

import java.util.NoSuchElementException;

public class MyArrayList<E> {
    private E[] data;
    private int size;
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int cap) {
        data = (E[]) new Object[cap];
        size = 0;
    }

    // 增
    public void add(int index, E elem) {
        checkPositionIndex(index);
        // 扩容
        if (data.length == size) {
            resize(2 * data.length);
        }
        // 元素后移
        // System.arraycopy(data, index, data, index + 1, size - index);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = elem;
        size++;
    }

    public void addLast(E elem) {
        // 扩容
        if (data.length == size) {
            resize(2 * data.length);
        }
        data[size] = elem;
        size++;
    }

    // 删
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // 缩容
        if (size < data.length / 4) {
            resize(data.length / 2);
        }

        E res = data[size - 1];

        // 置为 null 方便垃圾回收
        data[size - 1] = null;
        size--;

        return res;
    }

    public E remove(int index) {
        checkElementIndex(index);
        E elem = data[index];
        // 缩容
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        // 数据搬移
        // System.arraycopy(data, index + 1, data, index, size - index - 1);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 删除最后一个元素，垃圾回收
        data[size - 1] = null;
        size--;
        return elem;
    }

    // 查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    // 改
    public void set(int index, E elem) {
        checkElementIndex(index);
        data[index] = elem;
    }

    // 工具函数
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查 index 处是否存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    // 检查 index 处是否可以插入元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize(int newCap) {
        E[] newData = (E[]) new Object[newCap];
        // if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
