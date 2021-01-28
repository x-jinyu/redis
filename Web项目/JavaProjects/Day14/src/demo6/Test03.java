package demo6;

/**
 * 王金宇
 * 2020/10/13 0013
 * 定义方法,实现int[]数组元素的乱序
 */
public class Test03 {
    public static void main(String[] args) {
        int[] ints = shuffle(10);
        printArry(ints);
    }

    private static void printArry(int[] arry) {
        for (int i : arry) {
            System.out.println(i);
        }
    }

    private static int[] shuffle(int num) {
        int[] ints = new int[num];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * ints.length);
        }
        return ints;
    }
}
