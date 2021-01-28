package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:/ddd/JavaSE进阶-5IO流-001 IO流概述.avi");
            fos = new FileOutputStream("D:/abc/JavaSE进阶-5IO流-001 IO流概述.avi");
            int read = fis.read();
            while (read != -1) {
                fos.write(read);
                read = fis.read();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null && fos != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("main...........");
    }
}
