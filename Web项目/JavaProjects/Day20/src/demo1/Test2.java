package demo1;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        sm("王金宇", "GBK");
        sm("王金宇", "UTF8");
        sm("王金宇", "GB2312");


    }

    public static void sm(String text,String charsetName) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes(charsetName);
        System.out.println(Arrays.toString(bytes));
    }
}
