package basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Code017 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);

//        add(element)：向集合中添加元素，如果元素已存在，则不会重复添加。
//        remove(element)：从集合中移除指定元素。
//        contains(element)：检查集合中是否包含指定元素。
//        isEmpty()：判断集合是否为空。
//        size()：返回集合中的元素数量。
//        clear()：清空集合中的所有元素。

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            // 声明一个 set
            Set<Integer> set = new HashSet<>();
            int m = sc.nextInt();
            while (m > 0) {
                // 向 set 中添加数据
                set.add(sc.nextInt());
                m--;
            }
            // 遍历 set 方法 1：增强 for
            for (int e : set) {
                System.out.print(e);
            }
            System.out.println();
            // 遍历 set 方法 2：获取 set 的迭代器
            Iterator<Integer> it = set.iterator();
            // 是否还有下一个元素
            while (it.hasNext()) {
                // 读取下一个元素
                int e = it.next();
                System.out.print(e);
            }
            System.out.println();
            int n = sc.nextInt();
            // set 中是否包含数据
            if (set.contains(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
