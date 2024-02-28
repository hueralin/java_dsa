package basic;

import java.util.Scanner;

public class Code015 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        LinkList list = new LinkList();

        // 构建链表
        while (k > 0) {
            list.insert(sc.nextInt());
            k--;
        }

        // 打印链表
        list.print();

        // 插入元素
        int s = sc.nextInt();
        while (s > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            LinkList.Node node = list.insert(n, x);
            if (node != null) {
                list.print();
            } else {
                System.out.println("Insertion position is invalid.");
            }
            s--;
        }

        // 删除元素
        int l = sc.nextInt();
        while (l > 0) {
            int m = sc.nextInt();
            LinkList.Node node = list.delete(m);
            if (node != null) {
                list.print();
            } else {
                System.out.println("Deletion position is invalid.");
            }
            l--;
        }

        sc.close();
    }
}
