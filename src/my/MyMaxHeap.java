package my;

import java.util.Arrays;

public class MyMaxHeap {
    private int[] data;
    private int size;

    public void setData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyMaxHeap() {
        this(10);
    }

    public MyMaxHeap(int cap) {
        // 0 空着
        data = new int[cap + 1];
        size = 0;
    }

    public void insert(int e) {
        if (size == data.length - 1) {
            System.out.println("Heap is full");
            return;
        }

        data[++size] = e;
        heapifyUp(size);
    }

    public int retrieve() {
        int res = data[0];
        data[0] = data[size--];
        heapifyDown(0);
        return res;
    }

    public static MyMaxHeap heapify(int[] arr) {
        MyMaxHeap heap = new MyMaxHeap(arr.length);
        heap.setData(arr);
        heap.setSize(arr.length);

        for (int i = arr.length / 2; i > 0; i--) {
            heap.heapifyDown(i);
        }

        return heap;
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    // ************** 工具函数 *****************

    public void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public void heapifyUp(int i) {
        // 因为 0 是空着的，因此不能取 0，所以 i > 1
        while (i > 1 && data[i] > data[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public void heapifyDown(int i) {
        while (2 * i <= size) {
            // 寻找较大的孩子
            int childIdx = 2 * i;
            if (childIdx != size && data[childIdx + 1] > data[childIdx]) {
                childIdx++;
            }
            if (data[i] > data[childIdx]) {
                break;
            } else {
                swap(i, childIdx);
            }
            i = childIdx;
        }
    }
}
