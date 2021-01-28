package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/30 0030
 * 6.编写一个程序，让用户输入一个正整数值，然后计算该数各位数的和(使用循环完成)
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入一个正整数");
        int i = input.nextInt();
        System.out.println(num(i));
    }

    public static int num(int i) {
        int num = 0;
        while (i != 0){
            num = num + i % 10;
            i /= 10;
        }
        return num;
    }
}
