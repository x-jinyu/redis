package demo2;

import java.util.ResourceBundle;

/**
 * 王金宇
 * 2020/10/20 0020
 */
public class Test1 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("resources/config");

        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
        System.out.println(bundle.getString("用户名"));
    }
}
