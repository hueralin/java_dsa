package leetcode;

public class P860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                money[1]++;
                // 要找 5 块钱
                if (money[0] == 0) {
                    return false;
                } else {
                    money[0]--;
                }
            } else if (bill == 20) {
                money[2]++;
                // 找 15 块钱
                int x = 15;
                // 优先找 10 块
                while (x >= 10 && money[1] > 0) {
                    money[1]--;
                    x -= 10;
                }
                while (x >= 5 && money[0] > 0) {
                    money[0]--;
                    x -= 5;
                }
                if (x != 0) return false;
            }
        }
        return true;
    }
}
