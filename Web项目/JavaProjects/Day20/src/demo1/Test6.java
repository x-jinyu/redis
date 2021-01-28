package demo1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/23 0023
 */

public class Test6 {
    public static void main(String[] args) {
        //m1();
        m2();
    }

    public static void m2() {
        try (FileInputStream fis = new FileInputStream("d:/abc.txt")) {
            byte[] bytes = new byte[1];
            int read = fis.read(bytes);
            while (read != -1) {
                String str = new String(bytes, 0, read);
                System.out.print(str + "\t");
                read = fis.read(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void m1() {
        try (FileInputStream fis = new FileInputStream("d:/abc.txt")) {
            byte[] bytes = new byte[4];
            int read = fis.read(bytes);
            System.out.println(read);
            System.out.println(Arrays.toString(bytes));

            read = fis.read(bytes);
            System.out.println(read);
            System.out.println(Arrays.toString(bytes));

            read = fis.read(bytes);
            System.out.println(read);
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
