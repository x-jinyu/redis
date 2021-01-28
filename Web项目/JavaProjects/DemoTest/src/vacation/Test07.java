package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/30 0030
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制。
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字a");
        int a = input.nextInt();
        System.out.println("请输入s的值由几个数相加");
        int b = input.nextInt();
        sum(a, b);
    }

    public static void sum(int a, int b) {
        int s = a;
        int c = 0;
        for (int i = 1; i < b; i++){
            a = a * 10 + a % 10;
            c += a;
        }
        System.out.println("s的值为：" + (c + s));
    }
}
