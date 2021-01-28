package demo2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 王金宇
 * 2020/10/20 0020
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream in = Test.class.getClassLoader().getResourceAsStream("resources/config.properties");
        //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/config.properties");

        properties.load(in);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("用户名"));
    }
}
