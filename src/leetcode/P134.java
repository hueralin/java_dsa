package leetcode;

public class P134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int rest = gas[i] - cost[i];
            int j = (i + 1) % n;
            while (rest > 0 && j != i) {
                rest += gas[j] - cost[j];
                j = (j + 1) % n;
            }
            if (rest >= 0 && j == i) return i;
        }
        return -1;
    }
}
