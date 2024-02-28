package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Code016 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            System.out.println(findMostFrequentChar(input));
        }

        sc.close();
    }

    public static char findMostFrequentChar(String str) {
        char[] chs = str.toCharArray();
        // 26 个小写字母
        int[] map = new int[26];
        // 统计频率
        for (char c: chs) {
            // 相对位置，'a' - 'a' 就是 0，以此类推
            map[c - 'a']++;
        }
        // 找到最大频率的字符
        char maxChar = 'a';
        int maxFreq = map[0];
        for (int i = 0; i < map.length; i++) {
            if (map[i] > maxFreq) {
                maxChar = (char)(i + 'a');
                maxFreq = map[i];
            }
        }
        return maxChar;
    }
}
