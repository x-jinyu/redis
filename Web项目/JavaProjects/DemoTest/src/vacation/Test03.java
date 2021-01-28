package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/29 0029
 * 从键盘上输入正数和负数,分别统计正数的个数和负数的个数,并计算所有数的和.输入0表示结束.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        sum(input, num1, num2, sum);


    }

    public static void sum(Scanner input, int num1, int num2, int sum) {
        for (;;){
            System.out.println("请输入一数字：");
            int i = input.nextInt();
            sum += i;
            if (i > 0){
                num1++;
            }else if (i < 0){
                num2++;
            }else if (i == 0){
                break;
            }
        }
        System.out.println("正数个数为：" + num1 + "负数的个数为：" + num2 + "所有数字和为：" + sum);
    }
}
