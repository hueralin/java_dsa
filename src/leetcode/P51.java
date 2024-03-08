package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P51 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b: board) {
            Arrays.fill(b, '.');
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = '.';
//            }
//        }
        backtrace(board, 0);
        return res;
    }
    public void backtrace(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            res.add(mapToList(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrace(board, row + 1);
                // 回溯
                board[row][col] = '.';
            }
        }
    }
    // 检查 [row, col] 位置放置皇后的话是否合法
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 不用检查行，因为我们知道不能放在同一行，根本不会往行上放皇后，代码都是递归写的，直接考虑往下一行放皇后
        // 检查列（列不动，遍历行）
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查 45 度角（只关注前面的元素）
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查 135 度角（只关注前面的元素）
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    public List<String> mapToList(char[][] board) {
        List<String> list = new LinkedList<>();
        for (char[] b: board) {
            StringBuilder sb = new StringBuilder();
            for (char c : b) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
