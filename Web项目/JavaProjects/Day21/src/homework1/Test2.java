package homework1;

import java.io.File;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test2 {
    public static void main(String[] args) {

    }

    public static void m2(String str){
        File dir = new File(str);

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()){
                file.delete();
            }else {
                m2(file.getAbsolutePath());
            }
        }
        dir.delete();
    }
}
