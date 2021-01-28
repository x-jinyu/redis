package homework;

import java.io.File;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test {
    public static void main(String[] args) {
        m2("D:/files1/abc");
    }

    public static void m2(String str) {
        File f1 = new File(str);

        File[] files = f1.listFiles();
        if (f1.exists()) {
            for (File file : files) {
                if (file.listFiles() != null) {
                    file.delete();
                    m2(file.getAbsolutePath());
                }
                file.delete();
            }
            f1.delete();
        }
    }

    public static void m1(String str) {
        File f1 = new File(str);

        File[] files = f1.listFiles();

        for (File file : files) {
            if (file.listFiles() != null) {
                System.out.println(file);

                m1(file.getAbsolutePath());
            }
            System.out.println(file);
        }
    }
}
