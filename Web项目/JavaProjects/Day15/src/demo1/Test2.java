package demo1;

import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class Test2 {
    public static void main(String[] args) {
        int[] data = {1, 54, 9, 98, 42, 44, 6};
        String s = Arrays.toString(data);
        System.out.println(s);

        int[] bigger = Arrays.copyOf(data, data.length + 1);
        System.out.println(Arrays.toString(bigger));

        int[] small = Arrays.copyOf(data, data.length - 1);
        System.out.println(Arrays.toString(small));

        Arrays.sort(data); //对数组进行排序，排序之后，原数组会发生改变，直接遍历原数组即可
        System.out.println(Arrays.toString(data));

        System.out.println(Arrays.binarySearch(data,44));
        System.out.println(Arrays.binarySearch(data,2));
        System.out.println(Arrays.binarySearch(data,98));

    }
}
