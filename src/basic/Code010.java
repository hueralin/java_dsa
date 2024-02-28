package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Code010 {
    public static void solution() {
        // 字符串的初始化
        // 字面量
        String s1 = "Hello";
        // new
        String s2 = new String("World");

        // + 拼接字符串
        String s3 = s1 + " " + s2;
        System.out.println(s3);

        // 字符串长度
        int len = s3.length();

        // 字符串比较
        System.out.println(s3.equals("hahaha")); // false
        System.out.println(s3.equals("Hello World")); // true

        // 字符串索引
        char c1 = s1.charAt(0);
        System.out.println(c1); // "H"

        // 字符串分割
        String[] arr = s3.split(" ");
        System.out.println(Arrays.toString(arr));

        // 查找和替换
        int index = s3.indexOf("ll");
        System.out.println(index); // 2
        String s4 = s3.replace("World", "Java");
        System.out.println(s4); // "Hello Java"

        // 读取和判断是否还有文本输入
        // sc.nextLine() & sc.hasNextLine()

        // 开始做题
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            String[] scores = in.split(" ");
            double sum = 0;
            boolean flag = true;
            for (String score: scores) {
                switch (score) {
                    case "A": sum += 4; break;
                    case "B": sum += 3; break;
                    case "C": sum += 2; break;
                    case "D": sum += 1; break;
                    case "F": sum += 0; break;
                    default: flag = false;
                }
                if (!flag) break;
            }
            if (flag) {
                System.out.printf("%.2f\n", sum / scores.length);
            } else {
                System.out.println("Unknown");
            }
        }

        sc.close();
    }
}
