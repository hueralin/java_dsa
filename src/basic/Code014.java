package basic;

import java.util.Scanner;

public class Code014 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkList list = new LinkList();

        // 构造链表
        while (n > 0) {
            list.insert(sc.nextInt());
            n--;
        }

        // 获取链表中第 i 个元素
        while (m > 0) {
            LinkList.Node node = list.get(sc.nextInt());
            if (node != null) {
                System.out.println(node.data);
            } else {
                System.out.println("Output position out of bounds.");
            }
            m--;
        }

        sc.close();
    }
}
