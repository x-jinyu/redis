package demo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("D:/files/log.txt",true));

        printStream.print("数据不换行");
        printStream.println("数据换行");
        printStream.print("第二行");
        System.out.println("直接在屏幕打印");

        PrintStream old = System.out;
        System.setOut(printStream);     //该方法修改了System.out的打印方向
        System.out.println("直接打印在文件中");
        System.setOut(old);
        System.out.println("直接打印在屏幕上");

        try {
            byte[] gbks = "把字符串转换为GBK编码的字节数组".getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            e.printStackTrace(printStream);
        }

        printStream.close();
    }
}
