package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P347 {
    // map + 快速排序
//    public int[] topKFrequent(int[] nums, int k) {
//        // 存储每个关键字的频率
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        // 排序频率
//        int[] arr = new int[k];
//        for (int k)
//        // 获取第 k 个
//    }

    // map + 小顶堆
    public int[] topKFrequent2(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(new int[]{ entry.getKey(), entry.getValue() });
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }
}
