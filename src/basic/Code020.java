package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code020 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> queue = new LinkedList<>();
        while (n > 0) {
            queue.add(sc.next());
            n--;
        }
        int m = sc.nextInt();
        while (m > 0) {
            int op = sc.nextInt();
            if (op == 1 && !queue.isEmpty()) {
                queue.poll();
            } else if (op == 2) {
                queue.add(sc.next());
            }
            m--;
        }
        if (queue.isEmpty()) {
            System.out.println("There are no more people in the queue.");
        } else {
            System.out.println(queue.peek());
        }
        sc.close();
    }
}
