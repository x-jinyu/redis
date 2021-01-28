package vacation;

import java.util.Scanner;

/**
 * 2020/9/27 0027
 */
public class ShapeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入行数");
        int h = input.nextInt();
        for (int i = 1; i <= h; i++){
            for (int j = i; j <= h; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= h - 1; i++){
            for (int j = 1; j <= i + 1; j++){
                System.out.print(" ");
            }
            for (int k = 2 * h - 2; k > 2 * i - 1; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        /*for (int i = h; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for (int l = h; l >= i; l--){
                System.out.print("*");
            }
            for (int k = i; k < h; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= h; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(" ");
            }
            for (int l = h; l > i; l--){
                System.out.print("*");
            }
            for (int k = i; k < h - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }*/
    }
}
