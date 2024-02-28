package kama;

import java.util.*;

public class T11F {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.add(sc.nextInt());
            n--;
        }

        // 开始
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        while (k > 0 && !queue.isEmpty()) {
            int e = queue.poll();
            int idx = list.indexOf(e);
            if (idx - 1 >= 0) {
                list.set(idx - 1, list.get(idx - 1) + e);
            }
            if (idx + 1 < list.size()) {
                list.set(idx + 1, list.get(idx + 1) + e);
            }
            list.remove(idx);
            // 重新建堆
            queue.clear();
            queue.addAll(list);
            k--;
        }

        // 输出
        for (int e: list) {
            System.out.printf("%d ", e);
        }

        sc.close();
    }
}
