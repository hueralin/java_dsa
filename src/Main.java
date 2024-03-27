import leetcode.*;
import my.MyMaxHeap;
import my.MyPriorityQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] stones = {0,0,0,0,0,0,0,0,1};
        P494 p = new P494();
        int v = p.findTargetSumWays2(stones, 1);
        System.out.println(v);
    }
}
