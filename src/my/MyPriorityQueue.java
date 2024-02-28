package my;

import java.util.Arrays;

public class MyPriorityQueue {
    private final int[] data;
    private int size;
    private final int capacity;

    public MyPriorityQueue() {
        this(10);
    }

    public MyPriorityQueue(int cap) {
        capacity = cap;
        // data[0] 空着，方便完全二叉树计算
        data = new int[capacity + 1];
        size = 0;
    }

    public void insert(int elem) {
        if (size == capacity) {
            System.out.println("满了");
            return;
        }

        // 将新元素先放到 data 的最后面
        int i = ++size;
        data[i] = elem;

        // 然后调整
        while (i > 1 && elem > data[i / 2]) {
            // 父级下移
            data[i] = data[i / 2];
            i = i / 2;
        }

        // 插入元素
        data[i] = elem;
        System.out.printf("插入 %d 元素后，优先队列的样子: %s \n", elem, Arrays.toString(data));
    }

    public int delete() {
        if (size == 0) {
            throw new Error("队列为空");
        }

        // 要删除的元素
        int deletedValue = data[0];

        // 最后一个元素，假装要放在第一个位置
        int tmp = data[size];
        // 从第一个位置开始遍历
        int pIdx = 1;

        while (2 * pIdx <= size) {
            // 找到左右孩子中的较大值
            // 表示较大的孩子节点
            int cIdx = 2 * pIdx;
            // 如果有右孩子，且右孩子大，则接下来使用右孩子
            if (cIdx != size && data[cIdx] < data[cIdx + 1]) {
                cIdx++;
            }
            if (tmp > data[cIdx]) {
                break;
            } else {
                // 孩子上移
                data[pIdx] = data[cIdx];
            }
            pIdx = cIdx;
        }

        // 将原来的最后一个元素归位到此处
        data[pIdx] = tmp;
        // 原来的最后一个元素可能要清除掉，减少内存泄漏的风险
        size--;

        System.out.printf("删除元素后优先队列的样子: %s \n", Arrays.toString(data));

        return deletedValue;
    }
}
