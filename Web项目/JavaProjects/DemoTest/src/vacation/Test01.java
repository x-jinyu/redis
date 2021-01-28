package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/29 0029
 * 输入三个数分别存放在变量x、y、z中，要求：输入的数按照从小到大的顺序存放在变量x、y、z中，最后输出三个变量中的值.
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int x = input.nextInt();
        System.out.println("请输入第二个数");
        int y = input.nextInt();
        System.out.println("请输入第三个数");
        int z = input.nextInt();

        judge(x, y, z);

    }

    public static void judge(int x, int y, int z) {
        if (x > y){
            int a = x;
            x = y;
            y = a;
        }
        if (x > z){
            int b = x;
            x = z;
            z = b;

        }
        if (y > z){
            int c = y;
            y = z;
            z = c;
        }

        System.out.println(x + "<" + y + "<" + z);
    }
}
