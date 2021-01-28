package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test2 {
    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream("D:/ddd/JavaSE进阶-5IO流-001 IO流概述.avi");
                FileOutputStream fos = new FileOutputStream("D:/abc/tmp.avi")
                ) {
            byte[] bytes = new byte[1024*8];    //数组长度为1024的倍数
            int read = fis.read(bytes);
            while (read != -1){
                fos.write(bytes , 0 ,read); //问题
                read = fis.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
