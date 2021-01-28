package demo1;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test3 {
    public static void main(String[] args){
        sm("王金宇", "GBK");
        sm("王金宇", "UT8");
        sm("王金宇", "GB2312");


    }

    public static void sm(String text,String charsetName){
        byte[] bytes = new byte[0];
        try {
            bytes = text.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes));
    }
}
