package kama;

import java.util.Scanner;

public class T11A {
    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 开始计算
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        // 寻找最大值
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i][0] / arr[i][1];
            if (tmp < max) {
                max = tmp;
            }
        }

        for (int i = max; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][0] / i > arr[j][1]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            min = i;
        }

        System.out.printf("%d %d\n", min, max);

        sc.close();
    }
}
