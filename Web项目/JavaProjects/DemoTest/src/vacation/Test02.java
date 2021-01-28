package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/29 0029
 * 计算n!,如：5! = 5 * 4 * 3 * 2 * 1
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数以计算阶乘（无法计算负数，请勿尝试）");
        int i = input.nextInt();
        System.out.println(factorial(i));
    }

    public static int factorial(int i) {
        int sum = 1;
        /*for (int j = i;true; j--){
            sum *= j;
            if (j == 1){
                break;
            }
        }
        System.out.println(sum);*/
        for (int j = 1; j <= i; j++){
            //System.out.println(j);
            sum *= j;
        }
        return sum;
    }
}
