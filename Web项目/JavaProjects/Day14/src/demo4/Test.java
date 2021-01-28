package demo4;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入20个数字存入数组当中");
        Double[] arry = new Double[2];
        int i = 0;
        for (; i < arry.length; i++) {
            double num = input.nextDouble();
            arry[i] = num;
        }
        /*for (double a :arry) {
            System.out.println(a);
        }*/

    }
}
