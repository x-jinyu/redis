package demo5;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "hello";

        byte[] bytes = {65,66,67,68,69,70};
        String s2 = new String(bytes);
        System.out.println(s2);
        s2 = new String(bytes, 0, 3);
        System.out.println(s2);

        char[] chars = {'a','b','c',64,65};
        String s3 = new String(chars, 0, chars.length);
        System.out.println(s3);
    }
}
