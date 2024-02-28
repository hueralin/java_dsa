package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Code018 {
    public static void solution() {
//        put(key, value)：将指定的键和值添加到map中，如果键已存在，则替换对应的值。
//        get(key)：根据key获取对应的值value。
//        remove(key)：根据key移除对应的键值对。
//        containsKey(key)：检查map中是否包含key键。
//        containsValue(value)：检查map中是否包含value值。
//        keySet()：返回包含所有键的集合。
//        values()：返回包含所有值的集合。
//        entrySet()：返回包含所有键值对的集合。
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            while (n > 0) {
                int k = sc.nextInt();
                int d = sc.nextInt();
                map.put(d, k);
                n--;
            }
            // 遍历 key
            for (int k: map.keySet()) {
                System.out.printf("%d ", k);
            }
            System.out.println();
            // 遍历 value
            for (int v: map.values()) {
                System.out.printf("%d ", v);
            }
            System.out.println();
            // 遍历 kv
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                System.out.printf("%d: %d ", entry.getKey(), entry.getValue());
            }
            System.out.println();
            int x = sc.nextInt();
            if (map.containsKey(x)) {
                System.out.println(map.get(x));
            } else {
                System.out.println("Can't open the door.");
            }
        }

        sc.close();
    }
}
