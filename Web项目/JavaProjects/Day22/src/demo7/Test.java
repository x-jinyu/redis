package demo7;

import java.util.ResourceBundle;

/**
 * 王金宇
 * 2020/10/30 0030
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        ResourceBundle bundle = ResourceBundle.getBundle("resources/config");
        final String classname = bundle.getString("classname");
        Class<?> aClass = Class.forName(classname);

        final int mod = aClass.getModifiers();
        System.out.println(mod);
    }
}
