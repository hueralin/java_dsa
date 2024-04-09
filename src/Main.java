import leetcode.*;
import my.MyMaxHeap;
import my.MyPriorityQueue;
import sort.Bubble;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 3, 28, 31, 22, 8, 29, 25};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
