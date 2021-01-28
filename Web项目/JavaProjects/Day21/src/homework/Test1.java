package homework;

import java.io.File;

/**
 * 王金宇
 * 2020/10/24 0024
 * 定义方法把指定文件夹的内容显示出来,包括子文件夹的内容
 */
public class Test1 {
    public static void main(String[] args) {
        m1("D:/files");
    }

    public static void m1(String str){
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
