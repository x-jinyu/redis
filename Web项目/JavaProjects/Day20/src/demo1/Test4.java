package demo1;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/abc.txt");
        System.out.println(fis.available());
        System.out.println(fis.read());
        System.out.println(fis.available());
        fis.skip(2);
        System.out.println(fis.available());
        System.out.println(fis.read());
        fis.close();
    }
}
