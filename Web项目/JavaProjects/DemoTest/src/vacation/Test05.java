package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/29 0029
 * 从键盘上输入一个数,逆序输出
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正数，该数范围需在0-999999999，如果超出范围，将提前结束程序");
        int i = input.nextInt();
        System.out.println(order(i));
    }

    public static int order(int i) {
        int num = 0;
        while (i != 0){
            num = num * 10 + i % 10;
            i = i / 10;
        }
        return num;
    }
}
