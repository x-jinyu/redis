package demo2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:/files/log.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        osw.write("utf8环境中写入的字符串");
        osw.close();
    }
}
