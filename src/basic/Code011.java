package basic;

import java.util.Scanner;

public class Code011 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 吸收掉输入完 n 后的回车
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String input = sc.nextLine().trim();
            char[] chs = input.toCharArray();
            int j = 0;
            while (j < chs.length) {
                // 如果首字母是小写，就改为大写
                if (chs[j] >= 'a' && chs[j] <= 'z') {
                    chs[j] = Character.toUpperCase(chs[j]);
                }
                // 构建结果字符串
                sb.append(chs[j]);
                // 跳过单词中首字母之外的字符
                while (j < chs.length && chs[j] != ' ') j++;
                // 跳过单词后面的空格
                while (j < chs.length && chs[j] == ' ') j++;
            }
            System.out.println(sb);
        }

        sc.close();
    }
}
