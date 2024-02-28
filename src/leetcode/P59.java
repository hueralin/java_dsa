package leetcode;

public class P59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int count = 1;

        while (top <= bottom && left <= right) {
            // 削去上边界
            for (int i = left; i <= right; i++) {
                res[top][i] = count++;
            }
            top++;
            // 削去右边界
            for (int i = top; i <= bottom; i++) {
                res[i][right] = count++;
            }
            right--;
            // 削去下边界
            for (int i = right; i >= left; i--) {
                res[bottom][i] = count++;
            }
            bottom--;
            // 削去左边界
            for (int i = bottom; i >= top; i--) {
                res[i][left] = count++;
            }
            left++;
        }

        return res;
    }
}
