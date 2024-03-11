package sort;

public class Quick {
    public static void sort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    public static void helper(int[] arr, int low, int high) {
        if (low <= high) return;
        int mid = partition(arr, low, high);
        helper(arr, low, mid - 1);
        helper(arr, mid + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        // 取 low 作为切分元素
        int midVal = arr[low];

        while (true) {
            // 寻找第一个比 midVal 大的值
            while (arr[i] <= midVal) {
                i++;
                if (i == high) break;
            }
            // 寻找第一个比 midVal 小的值
            while (arr[j] >= midVal) {
                j--;
                if (j == low) break;
            }

            if (i >= j) break;

            // 交换这两个值
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            // 继续找，直到 i, j 碰头，或者 i, j 越界
        }

        // i, j 碰头，将 j 和切分元素交换
        arr[low] = arr[j];
        arr[j] = midVal;

        return j;
    }
}
