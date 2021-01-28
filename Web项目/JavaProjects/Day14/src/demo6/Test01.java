package demo6;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arry = {1, 2, 33, 44, 5, 6, 77, 8, 99, 10};
        gerPrint(arry);
        Test.printIntArry(arry);

        /*for (int i : arry) {
            System.out.println(i);
        }*/

    }

    private static void gerPrint(int[] arry) {
        for (int i = 0; i < arry.length / 2; i++) {
            int temp = arry[i];
            arry[i] = arry[arry.length - 1 -i];
            arry[arry.length - 1 -i] = temp;
        }
    }
}
