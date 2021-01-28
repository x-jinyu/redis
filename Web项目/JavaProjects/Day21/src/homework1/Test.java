package homework1;

import java.io.File;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test {
    public static void main(String[] args) {
        m1("D:/files");
    }

    public static void m1(String str){
        File file = new File(str);

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
            if (f.isDirectory()){
                m1(f.getAbsolutePath());
            }
        }
    }
}
