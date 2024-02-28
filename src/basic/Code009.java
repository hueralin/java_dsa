package basic;

import java.util.Scanner;

public class Code009 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 外层控制行
        for (int i = 0; i < n; i++) {
            // 内层控制列
            for (int j = 0; j < n; j++) {
                // 处于边界打印 *，处于内部打印空格
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // 当前行结束，换行
            System.out.println();
        }
        sc.close();
    }
}
