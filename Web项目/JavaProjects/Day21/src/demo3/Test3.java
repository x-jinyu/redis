package demo3;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:/files/log.txt");
        if (f1.exists()){
            f1.delete();
        }
        f1.createNewFile();
        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.length());
        System.out.println(f1.getName());
        System.out.println(f1.getParent());
        long lastModified = f1.lastModified();
        System.out.println(new Date(lastModified));
    }
}
