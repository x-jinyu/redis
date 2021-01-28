package homework1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/20 0020
 * 定义Map保存<用户名,密码>,模拟用户注册与登录.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        while (true) {
            System.out.println("--------------------------主界面----------------------------------");
            System.out.println("    1注册    2登陆    3退出");
            System.out.println("请输入您的操作：");
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println("================用户注册====================");
                    System.out.println("请输入用户名:");
                    String username = input.next();
                    while (map.containsKey(username)) {
                        System.out.println("该用户已存在，请重新输入：");
                        username = input.next();
                    }
                    System.out.println("请输入密码：");
                    String password = input.next();
                    map.put(username, password);
                    continue;
                case 2:
                    System.out.println("=============== 用户登录 ==================");
                    System.out.println("请输入用户名:");
                    username = input.next();
                    System.out.println("请输入密码:");
                    password = input.next();
                    /*while (!password.equals(map.get(username))) {
                        System.out.println("用户名或密码不正确，是否重新登陆(Y/N)");
                        String login = input.next();
                        if (login.equals("y") || login.equals("Y")) {
                            System.out.println("请输入用户名:");
                            username = input.next();
                            System.out.println("请输入用户名:");
                            password = input.next();
                            continue;
                        } else if (login.equals("n") || login.equals("N")) {
                            break;
                        }
                    }*/
                    if (password.equals(map.get(username))) {
                        System.out.println("登陆成功");
                    }else {
                        System.out.println("用户名或密码不正确，请重新尝试");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("输入不正确，请重新尝试");
                    break;
            }
        }
    }

}