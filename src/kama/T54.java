package kama;

import java.util.Scanner;

public class T54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        StringBuilder sd = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sd.append("number");
            } else {
                sd.append(s.charAt(i));
            }
        }

        System.out.println(sd.toString());

        sc.close();
    }
}
