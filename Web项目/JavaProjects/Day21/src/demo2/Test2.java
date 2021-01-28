package demo2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/files/log.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");

        int read = isr.read();
        while (read != -1){
            System.out.println((char)read);
            read = isr.read();
        }

        isr.close();
    }
}
