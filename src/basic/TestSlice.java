package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSlice {
    public static void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOfRange(arr, 1, 4); // 左闭右开
        System.out.println(Arrays.toString(arr2)); // [2, 3, 4]

        String str = "hello";
        String str2 = str.substring(1, 4);
        System.out.println(str2); // "ell"

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = list.subList(1, 4);
        System.out.println(list2.toString()); // [2, 3, 4]
        System.out.println(Arrays.toString(list2.toArray())); // [2, 3, 4]
        List<Integer> list3 = new ArrayList<>(list2);
        System.out.println(list3.toString()); // [2, 3, 4]
    }
}
