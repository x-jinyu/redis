package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/30 0030
 * 定义一个方法判断一个数是否为素数
 */
public class Test09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数
        System.out.println("请输入一个数以判断是否是素数");
        int num = input.nextInt();
        prime(num);
    }

    public static boolean prime(int num) {
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
