package leetcode;

// 实际上是实现一些编程语言中容器删除元素的方法
public class P27 {
    // 暴力破解是一个双循环的解法，外层循环遍历每一个元素，内层循环碰到要删除的元素时将后面的元素挨个往前覆盖。

    // 时间复杂度 O(n), n 是原数组长度, m 是 val 的个数
    // 赋值操作了 n - m 次
    // 哈哈哈，看到一个解释是，right 去找萝卜，left 就是坑
    public int removeElement(int[] nums, int val) {
        // left 标识区间的终点，什么区间？没有 val 的区间，即本道题的答案，去掉 val 的区间。
        // [0, left)
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            // 将不等于 val 的值移动到区间
            // 不会改变原来元素的相对顺序
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        // 对于左闭右开的区间，区间长度等于 右 - 左
        return left;
    }

    // 时间复杂度 O(n), n 是原数组长度, m 是 val 的个数
    // 赋值操作了 m 次
    public int removeElement2(int[] nums, int val) {
        // 区间的定义仍然是上面那个
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                // 会改变原来元素的相对顺序
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    // 暴力解法
    public int removeElement3(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
                i--;
            }
        }
        return len;
    }
}
