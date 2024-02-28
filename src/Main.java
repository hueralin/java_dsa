import leetcode.*;
import my.MyMaxHeap;
import my.MyPriorityQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MyMaxHeap heap = MyMaxHeap.heapify(arr);
        heap.print();
    }
}
