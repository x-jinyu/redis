package homework2;

import java.util.*;

/**
 * 王金宇
 * 2020/10/19 0019
 * 请随机生成一注双色球号码。双色球投注区分为红色球号码区和蓝色球号码区，红色球号码区由1-33共三十三个号码组成，蓝色球号码区由1-16共十六个号码组成。投注时选择6个红色球号码和1个蓝色球号码组成一注进行单式投注.（要求同色号码不重复）
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();   //生成随机数
        TreeSet<Integer> set = new TreeSet<>();

        //存储最终的6个红球，一个蓝球

        while (set.size() < 6) {
            set.add(random.nextInt(33)+1);
        }
        //List<Integer> list = new ArrayList<>(set1);
        int i = random.nextInt(6);
        set.add(i);
        System.out.println(set);
    }
}
