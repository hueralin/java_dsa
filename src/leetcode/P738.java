package leetcode;

import java.util.LinkedList;

public class P738 {
    // 暴力，模拟，超时
    public int monotoneIncreasingDigits(int n) {
        for (int i = n; i > 0; i--) {
            int x = i;
            int prev = x % 10;
            while (x > 0) {
                int b = x % 10;
                if (b > prev) break;
                x /= 10;
                prev = b;
            }
            if (x == 0) return i;
        }
        return 0;
    }

    public int monotoneIncreasingDigits2(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        // flag 用于标志从哪个下标开始，后面所有的数字都变成 9
        // flag 初始化为 arr.length，这样即便没进入第一个 for，没修改 flag，也不会进入第二个 for
        int flag = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                arr[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < arr.length; i++) {
            arr[i] = '9';
        }
        return Integer.parseInt(new String(arr));
    }
}
