package demo5;

import java.text.Collator;
import java.util.Locale;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test01 {
    public static void main(String[] args) {
        String txt = "hello";
        System.out.println(txt.length());
        System.out.println(txt.charAt(4));
        System.out.println(txt.charAt(1));

        for (int i = 0; i < txt.length(); i++) {
            System.out.println(txt.charAt(i));
        }

        System.out.println("hello".compareTo("Helld"));
        System.out.println("A".compareTo("def"));
        System.out.println("张三".compareTo("李四"));
        Collator collator = Collator.getInstance(Locale.CHINESE);
        System.out.println(collator.compare("张三", "李四"));
        System.out.println("hello".compareToIgnoreCase("HELLO"));
    }
}
