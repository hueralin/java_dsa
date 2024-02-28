package kama;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Plane {
    int t, d, l, edge;
    public Plane(int t, int d, int l) {
        this.t = t;
        this.d = d;
        this.l = l;
        this.edge = t + d;
    }
}

public class T11B {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        while (m > 0) {
            int n = sc.nextInt();
            Plane[] planes = new Plane[n];

            for (int i = 0; i < n; i++) {
                planes[i] = new Plane(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            // 开始计算
            // 计算临界值，并按临界值从小到大排序
            PriorityQueue<Plane> queue = new PriorityQueue<>((p1, p2) -> {
                return p1.edge - p2.edge;
            });
            queue.addAll(Arrays.asList(planes));

            // 开始降落！
            int progress = 0;
            boolean flag = true;
            while (!queue.isEmpty()) {
                Plane p = queue.poll();
                if (progress > p.edge) {
                    flag = false;
                    break;
                }
                if (progress > 0) {
                    progress += p.l;
                } else {
                    progress = p.t + p.l;
                }
            }

            System.out.println(flag ? "YES" : "NO");

            m--;
        }

        sc.close();
    }
}
