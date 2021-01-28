package demo5;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入手机号码");
        String phoneNum = input.next();
        //判断手机号是否输入正确
        String patter = "1[356789]\\d{9}";
        System.out.println(phoneNum.matches(patter));

        String txt = "由123开始";
        String another = txt.replaceAll("\\d", "*");
        System.out.println(another);
        System.out.println(txt);

        txt = "A small step forward, a big step of civilization";
        String[] split = txt.split("[,]");
        for (String s : split) {
            System.out.print(s);
        }
    }
}
