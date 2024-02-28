package leetcode;

public class P69 {
    // 毫无疑问，超时了
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }
}
