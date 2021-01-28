package demo6;

import java.util.Random;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextDouble());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }

        Random r1 = new Random(123456);
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextDouble());

        }
    }
}
