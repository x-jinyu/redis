package homework1;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/16 0016
 * 从键盘上输入身份证号, 判断出生日期, 性别(倒数第二位是奇数表示男)
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入身份证号");
        String id = input.next();//键盘输入身份证号
        if (id.length() == 18) {
            //String s = new String(str);
            String s1 = id.substring(6, 10);   //取出10-12位的子串
            String s2 = id.substring(10, 12);   //取出10-12位的子串
            String s3 = id.substring(12, 14);   //取出12-14位的子串
            StringBuilder builder = new StringBuilder();
            StringBuilder birsd = builder.append(s1 + "年" + s2 + "月" + s3 + "日");  //将出生年月使用append方法连接起来
            System.out.println("出生日期为：" + birsd);
            char s4 = id.charAt(16);     //取出倒数第二位的字符
            //System.out.println(s4);
            if (s4 % 2 == 0) {
                    System.out.println("女");
                } else {
                    System.out.println("男");

                }
            //s1 = id.substring(id)
        } else {
            System.out.println("输入有误，无法判断");
        }
    }
}
