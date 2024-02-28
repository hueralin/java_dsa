package kama;
import java.util.Scanner;

public class T55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] arr = str.toCharArray();

        // 取最后一个元素
        char tmp = arr[arr.length - 1];
        while (k > 0 && k <= arr.length) {
            // 前面的元素后移
            for (int i = arr.length - 1; i > 0; i--) {
                // 后移，即低位覆盖高位
                arr[i] = arr[i - 1];
            }
            // 头插法
            arr[0] = tmp;
            // 取最后一个元素
            tmp = arr[arr.length - 1];
            k--;
        }

        System.out.println(new String(arr));

        sc.close();
    }
}