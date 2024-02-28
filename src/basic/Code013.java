package basic;

import java.util.Scanner;

public class Code013 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            LinkList list = new LinkList();

            for (int i = 0; i < n; i++) {
                list.insert(sc.nextInt());
            }

            list.print();
        }

        sc.close();
    }
}
