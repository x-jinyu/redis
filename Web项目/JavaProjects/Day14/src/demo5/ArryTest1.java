package demo5;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class ArryTest1 {
    public static void main(String[] args) {
        int[] arry = {2, 11, 33, 4, 1, 2, 6, 12, 8, 77};
        int min = 0;
        int max = 0;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] < arry[min]) {
                min = i;
            }
            if (arry[i] > arry[max]) {
                max = i;
            }
        }
        System.out.println("最大值为：" + arry[max]);
        System.out.println("最大值下标：" + max);
        System.out.println("最小值为：" + arry[min]);
        System.out.println("最小值下标：" + min);
    }
}
