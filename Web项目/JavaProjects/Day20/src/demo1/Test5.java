package demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test5 {
    public static void main(String[] args) {
        //m1();
        m2();
    }

    public static void m2() {
        try (FileInputStream fis = new FileInputStream("d:/abc.txt")) {
            int read = fis.read();
            while (read != -1) {
                System.out.println((char) read);
                read = fis.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void m1() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("d:/abc.txt");
            int read = fis.read();
            while (read != -1) {
                System.out.println((char) read);
                read = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("main...........");
    }
}
