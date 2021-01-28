package demo7;

import static demo6.Test.printIntArry;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test1 {
    public static void main(String[] args) {
        int[] data = {45, 67, 2, 3, 4, 5};
        //int[] a = getBig(data, 0, 2333);
        printIntArry(getDel(data, 1));
        //getDel(data, 1, 123);
    }

    /**
     * @param data 传递的数组参数
     * @param num1 需要插入到哪一行
     * @param num2 该数是需要插入的数据
     */
    public static int[] getBig(int[] data, int num1, int num2) {
        if (num1 < 0 || num1 > data.length) {
            System.out.println("需要插入的行数不合理");
            return data;
        }
        int[] bigger = new int[data.length + 1];
        System.arraycopy(data, 0, bigger, 0, num1);
        bigger[num1] = num2;
        System.arraycopy(data, num1, bigger, num1 + 1, data.length - num1);
        return bigger;
    }

    /**
     * @param data 传递的数组参数
     * @param num1 需要删除哪个下标的数据
     */
    public static int[] getDel(int[] data, int num1) {
        int[] small = new int[data.length - 1];
        System.arraycopy(data, 0, small, 0, num1);
        System.arraycopy(data, num1 + 1, small, num1, data.length-1 - num1);
        return small;
    }
}
//1 2  3  4  5
// 1  2 3 4