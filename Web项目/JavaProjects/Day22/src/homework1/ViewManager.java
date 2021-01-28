package homework1;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/28 0028
 * 该类为界面管理类
 */
public class ViewManager {
    private UserManager userManager = new UserManager();
    private CommodityManager commodity = new CommodityManager();
    Scanner sc = new Scanner(System.in);    //用于键盘输入

    //显示主界面
    public void showMainView() {
        while (true) {
            System.out.println("--------------------------主界面----------------------------------");
            System.out.println("1 浏览所有商品	2注册	3登陆	4退出");
            System.out.println("请输入你的操作: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                showCommodity();
            } else if (choice == 2) {
                register();      //注册
            } else if (choice == 3) {
                login();     //登录
            } else {
                System.exit(0);         //退出JVM, 0表示正常退出
            }
        }
    }

    public void showCommodity() {
        System.out.println("================商品信息====================");
        System.out.println("商品编号" + "\t\t商品名称" + "\t\t商品价格" + "\t\t销量");
        commodity.showCom();
        while (true) {
            System.out.println("选择排序方式：1 根据名称排序     2 根据价格升序    3根据销量降序    4返回上一层");
            int choice = sc.nextInt();
            if (choice == 1) {      //根据名称排序
                commodity.sortByName();
            } else if (choice == 2) {       //根据价格升序
                commodity.sortByPrice();
            } else if (choice == 3) {                         //根据销量降序
                commodity.sortBySales();
            } else {
                break;
            }
        }
    }

    public void login() {
        System.out.println("================用户登录===================");
        System.out.println("请输入用户名: ");
        String name = sc.next();
        System.out.println("请输入密码: ");
        String pwd = sc.next();
        //判断输入 的name用户名与pwd密码是否合法.
        if (userManager.validUser(name, pwd)) {
            System.out.println("登录成功");
            ProductControlView();
        } else {
            System.out.println("用户名或密码不正确");
        }
    }

    public void register() {
        System.out.println("================用户注册===================");
        System.out.println("请输入用户名: ");
        String name = sc.next();
        //判断用户名是否存在,当用户名已存在提示用户重新输入,
        while (userManager.containsName(name)) {
            System.out.println("该用户名已存在,请重新输入:");
            name = sc.next();
        }

        System.out.println("请输入密码: ");
        String pwd = sc.next();
        //注册就是把<name,pwd>添加到map集合中
        userManager.add(name, pwd);
        System.out.println("用户注册成功");
    }

    public void ProductControlView() {
        while (true) {
            System.out.println("================产品管理操作界面===================");
            System.out.println("1 显示所有商品	2添加商品	3删除商品	4修改商品    5查找商品  6退出");
            int choice = sc.nextInt();
            if (choice == 1) {
                showCommodity();
            } else if (choice == 2) {
                commodity.add();            //添加商品
            } else if (choice == 3) {
                commodity.remove();          //删除商品
            } else if (choice == 4) {
                commodity.modification();   //修改商品
            } else if (choice == 5) {
                commodity.findCommodity();//查找商品
            } else {
                System.exit(0);         //退出JVM, 0表示正常退出
            }
        }
    }
}
