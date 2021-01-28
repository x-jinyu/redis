package demo1;

import java.util.Scanner;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class Date {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年月日");
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        int sum = getSumDays(year, month, day);

        System.out.println(year + "年" + month + "月" + day + "日" + "第" + sum + "天");

        /*switch (num2){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (num3 <= 31) {
                    int j = 0;
                    for (int i = 1; i <= num2; i++) {
                        j++;
                    }
                    System.out.println(num1 + "年" + num2 + "月" + num3 + "日" + "第" + j + "天");
                }
            case 4: case 6: case 9: case 11:
                if (num3 <= 30) {
                    int j = 0;
                    for (int i = 1; i <= num3; i++) {
                        j++;
                    }
                    System.out.println(num1 + "年" + num2 + "月" + num3 + "日" + "第" + j + "天");
                    return;
                }
                System.out.println("日期输入有误");
            case 2:
                if (num2 == 2 && num1 % 4 == 0 && num1 % 100 != 0 || num1 % 400 ==0){
                    if (num2 == 2 && num3 <= 29){
                        int j = 0;
                        for (int i = 1; i <= num3; i++) {
                            j++;
                        }
                        System.out.println(num1 + "年" + num2 + "月" + num3 + "日" + "第" + j + "天");
                    }
                }else if (num2 == 2 && num3 <= 28) {
                    int j = 0;
                    for (int i = 1; i <= num3; i++) {
                        j++;
                    }
                    System.out.println(num1 + "年" + num2 + "月" + num3 + "日" + "第" + j + "天");
                    return;
                }
                System.out.println("日期输入有误");
        }

    }*/


    }

    /**
     * 对输入的日期进行判断是该年的第几天
     *
     * @param year  年份
     * @param month 月份
     * @param day   日期
     * @return      返回具体第几天
     */
    public static int getSumDays(int year, int month, int day) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += getSumMonthDays(year,i);
        }
        sum += day;
        return sum;
    }

    /**
     * 判断该年的某月有几天
     * @param year      年份
     * @param month     月份
     * @return          返回具体有几天
     */
    public static int getSumMonthDays(int year,int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isYears(year)){
                    return 29;
                }
                return 28;

        }
        return 0;
    }

    /**
     * 判断该年是否是闰年
     * @param year  年份
     * @return      是闰年返回true 不是返回false
     */
    public static boolean isYears(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
