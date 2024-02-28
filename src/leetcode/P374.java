package leetcode;

public class P374 {
    public int guess(int num) {
        // pick 值是题目给的
        int pick = 6;
        if (pick == num) return 0;
        else if (pick < num) return -1;
        else return 1;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + ((right - left ) >> 2);
            // guess 是题目给的方法
            int ok = guess(mid);
            if (ok == 0) {
                return mid;
            } else if (ok == -1) {
                right = mid - 1;
            } else if (ok == 1) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
