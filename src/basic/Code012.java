package basic;

import java.util.Scanner;

public class Code012 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            char[] chs = input.toCharArray();
            for (int j = 0; j < chs.length; j += 2) {
                swap(chs, j, j + 1);
            }
            // 使用 new String() 将 char[] 变为字符串
            System.out.println(new String(chs));
        }

        sc.close();
    }

    public static void swap(char[] chs, int i, int j) {
        char t = chs[i];
        chs[i] = chs[j];
        chs[j] = t;
    }
}
