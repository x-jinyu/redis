package homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 王金宇
 * 2020/10/15 0015
 * 该类使用数组完成斗地主游戏的端口登陆，发牌。
 */
public class Game {
    public static void main(String[] args) {
        /*if (args.length != 2) {
            System.out.println("该端口需要您输入用户姓名以及密码进行登陆，否则无法登陆");
            System.out.println("登陆完成后即可进行欢乐斗地主游戏");
            return;
        }
        //取出用户名以及密码用以判断
        String user = args[0];
        String password = args[1];
        //判断输入的用户账号以及姓名是否准确，不准确将结束该程序
        if (user.equals("admin") && password.equals("123")) {
            System.out.println("登录成功，欢迎[" + user + "]回来");
            System.out.println("由于该端口并没有进行图形界面的优化，所以，将以纯字体的形式将牌发出，收到牌后，需要输入想打的牌以进行游戏");

        } else {
            System.out.println("登陆失败，您输入的用户名或密码有误，请重新输入");
            return;
        }*/

        List<String> list = new ArrayList<>();
        String[] colorArr = {"♥","♠","♦","♣"};
        String[] data = new String[52];//设定初始的牌数为1，在循环完成后将所有54张牌添加到数组当中
        //int size = 0;//设定初始的数组下标为0，用以计算arr数组当中的元素个数
        //使用循环输出纸牌的花色以及54张牌
        //System.out.println("♥");
        /*for (int i = 2; i <= 14; i++) {  //判断牌数的多少j的值即为数组的下标值
            //System.out.println(j);    //测试j的值是否符合预期
            if (i >= 2 && i <= 10) {    //当满足1至10条件时，正常添加元素至数组当中
                data[size++] = "♥" + i;
            }
            switch (i) {                //当j超过10时，使用switch判断，以准确将后3张牌添加到数组当中
                case 11:
                    data[size++] = "♥" + "J";
                    break;
                case 12:
                    data[size++] = "♥" + "Q";
                    break;
                case 13:
                    data[size++] = "♥" + "K";
                    break;
                case 14:
                    data[size++] = "♥" + "A";
                    break;
            }
        }
        //添加♠花色到数组中
        for (int i = 2; i <= 14; i++) {  //该层循环用以判断牌数的多少j的值即为数组的下标值
            //System.out.println(j);    //测试j的值是否符合预期
            *//*if (size == data.length) {
                data = Arrays.copyOf(data, data.length + 14);
            }*//*
            if (i >= 2 && i <= 10) {    //当满足1至10条件时，正常添加元素至数组当中
                data[size++] = "♠" + i;
            }
            switch (i) {                //当j超过10时，使用switch判断，以准确将后3张牌添加到数组当中
                case 11:
                    data[size++] = "♠" + "J";
                    break;
                case 12:
                    data[size++] = "♠" + "Q";
                    break;
                case 13:
                    data[size++] = "♠" + "K";
                    break;
                case 14:
                    data[size++] = "♠" + "A";
                    break;
            }
        }
        //添加♦花色至数组中
        for (int i = 2; i <= 14; i++) {  //该层循环用以判断牌数的多少j的值即为数组的下标值
            //System.out.println(j);    //测试j的值是否符合预期
            *//*if (size == data.length) {
                data = Arrays.copyOf(data, data.length + 14);
            }*//*
            if (i >= 2 && i <= 10) {    //当满足1至10条件时，正常添加元素至数组当中
                data[size++] = "♦" + i;
            }
            switch (i) {                //当j超过10时，使用switch判断，以准确将后3张牌添加到数组当中
                case 11:
                    data[size++] = "♦" + "J";
                    break;
                case 12:
                    data[size++] = "♦" + "Q";
                    break;
                case 13:
                    data[size++] = "♦" + "K";
                    break;
                case 14:
                    data[size++] = "♦" + "A";
                    break;
            }
        }

        //添加♣花色至数组中
        for (int i = 2; i <= 14; i++) {  //该层循环用以判断牌数的多少j的值即为数组的下标值
            //System.out.println(j);    //测试j的值是否符合预期
            *//*if (size == data.length) {
                data = Arrays.copyOf(data, data.length + 14);
            }*//*
            if (i >= 2 && i <= 10) {    //当满足1至10条件时，正常添加元素至数组当中
                data[size++] = "♣" + i;
            }
            switch (i) {                //当j超过10时，使用switch判断，以准确将后3张牌添加到数组当中
                case 11:
                    data[size++] = "♣" + "J";
                    break;
                case 12:
                    data[size++] = "♣" + "Q";
                    break;
                case 13:
                    data[size++] = "♣" + "K";
                    break;
                case 14:
                    data[size++] = "♣" + "A";
                    break;
            }
        }

        data = Arrays.copyOf(data, data.length + 2);
        data[size++] = "大王";
        data[size++] = "小王";
*/

        //将数组内的内容随机打乱后遍历输出
        shuffle(data);

        String[] array = Arrays.copyOf(data, 16);

        //使用二维数组储存三幅牌，余三张底牌。
        //String[][] game;

        System.out.println("叫牌，每人只能叫一次。\n(1)叫牌时可以叫 “1” ， “2” ， “3” ， “ 不叫” 。\n(2)后叫牌者只能叫比前面玩家高的分或者不叫。叫牌结束后所叫分值最大的玩家为地主；\n(3)如果有玩家叫 “3” 则立即结束叫牌，该玩家为地主；如果都不叫，则重新发牌，重新叫牌。");
        //Scanner进行键盘输入判断是否输入的是抢地主，
        //Scanner input = new Scanner(System.in);
        //该循环控制叫地主的次数
        /*while (true) {
            shuffle(data);
            String game1 = input.next();//系统默认首次叫地主由玩家1开始，之后由胜家担任。
            String game2 = input.next();
            String game3 = input.next();
            if ("不叫".equals(game1)){    //三个玩家都不叫地主，牌面重新打乱
                if ("不叫".equals(game2)){
                    if ("不叫".equals(game3)){
                        shuffle(data);
                    }
                }else if ("1".equals(game2)){
                    if ("不叫".equals(game3)){
                        System.out.println();
                    }
                }

            }else if ("3".equals(game2)){   //玩家2如果叫三分，则成为地主，叫分结束
                System.out.println("该玩家为地主");
            }else if ("3".equals(game3)){   //玩家3如果叫三分，则成为地主，叫分结束
                System.out.println("");
            }
        }*/
        //定义一个二维数组，将两个农民，一个地主的牌进行保存，并且再将剩下的3张牌进行存储，总计4个一维数组
        //String[][] game = {};

        //遍历该数组
        printArray(array);

    }

    public static void printArray(String[] data) {
        for (String datum : data) {
            System.out.print(datum + " ");
        }
    }

    //该方法将所有扑克牌打乱后进行输出
    public static void shuffle(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int x = (int) (Math.random() * data.length);
            String t = data[i];
            data[i] = data[x];
            data[x] = t;
        }
    }
}
