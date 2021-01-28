package vacation;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/9/29 0029
 * 用户登录，提示用户输入用户名和密码，如果用户名和密码不是"admin"和"123"，则就提示用户继续输入，
 *   最多输入五次。
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        logIn(input, user, password);
    }

    public static void logIn(Scanner input, String user, String password) {
        for (int i = 5; i > 1; i--){
            if ("admin".equals(user) && "123".equals(password)){
                System.out.println("登陆成功，欢迎回家！");
                return;
            }else {
                System.out.println("请重新输入，您还有" + (i - 1) + "次机会");
                System.out.println("请输入用户名：");
                user = input.next();
                System.out.println("请输入密码：");
                password = input.next();
            }
        }
    }
}
