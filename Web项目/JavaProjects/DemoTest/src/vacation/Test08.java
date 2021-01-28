package vacation;

/**
 * 王金宇
 * 2020/9/30 0030
 * 输出如下效果，要求每次输出一个*
 * *
 * ***
 * *****
 */
public class Test08 {
    public static void main(String[] args) {
        star();
    }

    public static void star() {
        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= 2 * i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
