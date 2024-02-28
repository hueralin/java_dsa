package kama;

import java.util.Scanner;

public class T11E {
    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        String str = arr[0];
        String start = arr[1];
        String end = arr[2];

        if (str.length() < k) {
            System.out.println(0);
            return;
        }

        int num = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            for (int j = i + k - 1; j < str.length(); j++) {
                if (str.charAt(i) == start.charAt(0) && str.charAt(j) == end.charAt(0)) {
                    num++;
                }
            }
        }

        System.out.println(num);

        sc.close();
    }
}
