package demo5;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String txt = "hello动力节点";
        System.out.println(txt.contains("hello"));
        System.out.println(txt.contains("sss"));
        System.out.println(txt.endsWith("动力节点"));
        System.out.println(txt.startsWith("hello"));
        System.out.println(txt.equals("HELLO动力节点"));
        System.out.println(txt.equalsIgnoreCase("HELLO动力节点"));
        byte[] bytes = txt.getBytes();
        System.out.println(Arrays.toString(bytes));
        String s = new String(bytes);
        System.out.println(s);

        byte[] gbks = txt.getBytes("GBK");
        System.out.println(Arrays.toString(gbks));
        s = new String(gbks, "GBK");
        System.out.println(s);

        String path = "D:\\JavaProjects\\Day15\\src\\demo5\\Test02.java";
        int last = path.lastIndexOf("\\");
        int dot = path.lastIndexOf(".");
        String folder = path.substring(0, last);
        String filename = path.substring(last + 1, dot);
        String suffix = path.substring(dot + 1);
        System.out.println(folder);
        System.out.println(filename);
        System.out.println(suffix);

        char[] chars = txt.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        s = String.valueOf(chars);
        System.out.println(s);
        s = new String(chars);
        System.out.println(s);

        s = "Abc abc, Abc abc";
        String lowerCase = s.toLowerCase();
        String upperCase = s.toUpperCase();
        System.out.println(lowerCase);
        System.out.println(upperCase);
        System.out.println(s);

        s = "      Abc    Abc     ";
        String trim = s.trim();
        System.out.println(trim);

        int num = 456;
        s = String.valueOf(num);
        System.out.println(s);
        s = "456";
        num = Integer.parseInt(s);
        System.out.println(num);
    }
}
