package demo1;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年和月以打印输出该月的日历");
        int year = input.nextInt();
        int month = input.nextInt();
        System.out.println("一\t二\t三\t四\t五\t六\t日");

        //求出1900年至键盘输入的年份的之前一年的所有天数
        int sum = getSumMonthDays(year);

        //求出键盘输入月份之前的所有天数,并加到sum值当中
        sum += getSumDays(year, month);

        //System.out.println(sum % 7); //测试需要打印的日历一号空白的地方是星期几

        //总天数对7求余求出日历中空白的地方
        for (int i = 1; i <= sum % 7; i++) {
            System.out.print("\t");
        }

        sum += 1; //加1代表从需要打印的日历1号开始整体求余数，因为sum不加1，1号的位置会占用上个月最后一天的位置
        //循环求出日历
        for (int i = 1; i <= Date.getSumMonthDays(year, month); i++) {
            System.out.print(i + "\t");
            if (sum % 7 == 0) {
                System.out.println();
            }
            sum++;
        }
    }

    //该方法得出输入的月份之前月的天数，类似输入9，即可得出1至9月份所有的天数
    private static int getSumDays(int year, int month) {
        int sum = 0;
        for (int i = 0; i < month; i++) {
            sum += Date.getSumMonthDays(year, i);
        }
        return sum;
    }

    //该方法求1900年1月1日至需要求出的year总计需要多少天 类似 输入2020 即可得出1900年至2019年所有的天数
    private static int getSumMonthDays(int year) {
        int sum = 0;
        for (int i = 1900; i < year; i++) {
            if (Date.isYears(i)) {
                sum += 366;
            } else {
                sum += 355;
            }
        }
        return sum;
    }
}
