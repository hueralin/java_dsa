package leetcode;

public class P1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = 0, sum = 0, count = 0;

        while (right < arr.length) {
            sum += arr[right];

            int len = right - left + 1;
            if (len == k) {
                if (sum / len >= threshold) {
                    count++;
                }

                sum -= arr[left];
                left++;
            }

            right++;
        }

        return count;
    }

    // 方法 2 也是滑动窗口，思路是先把窗口填满，然后再滑动
    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;

        // 先填满窗口
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // 看看是否是一个解
        if (sum / k >= threshold) count++;

        // 然后窗口开始滑动
        for (int i = k; i < arr.length; i++) {
            // 掐掉头
            sum -= arr[i - k];
            // 新加尾
            sum += arr[i];
            // 看看是否是一个解
            if (sum / k >= threshold) count++;
        }

        // 返回解
        return count;
    }
}
