package basic;

import java.util.Scanner;

public class Code008 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int sum = 0;

            while (num > 0) {
                int mod = num % 10;
                if (mod % 2 == 0) {
                    sum += mod;
                }
                num /= 10;
            }

            System.out.println(sum);
            System.out.println();
        }

        sc.close();
    }
}
