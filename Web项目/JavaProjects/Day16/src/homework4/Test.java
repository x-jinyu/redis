package homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * 王金宇
 * 2020/10/18 0018
 * 科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚、日本，美国，中国，新西兰，巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利
 */
public class Test {
    public static void main(String[] args) {
        List<String> sum = new ArrayList<>();
        sum.add("科特迪瓦");
        sum.add("阿根廷");
        sum.add("澳大利亚");
        sum.add("塞尔维亚");
        sum.add("荷兰");
        sum.add("尼日利亚");
        sum.add("日本");
        sum.add("美国");
        sum.add("中国");
        sum.add("新西兰");
        sum.add("巴西");
        sum.add("比利时");
        sum.add("韩国");
        sum.add("喀麦隆");
        sum.add("洪都拉斯");
        sum.add("意大利");
        System.out.println("全部球队总计：" + sum);

        List<String> team1 = new ArrayList<>();
        List<String> team2 = new ArrayList<>();
        List<String> team3 = new ArrayList<>();
        List<String> team4 = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            //创建1-16的随机数
            int random = (int) (Math.random() * sum.size());
            //将随机值与每个位数相交换
            String s1 = sum.get(i);
            sum.set(i, sum.get(random));
            sum.set(random, s1);
        }
        //System.out.println(sum);
        for (int i = 0; i < 4; i++) {
            team1.add(sum.remove(0));
        }
        for (int i = 0; i < 4; i++) {
            team2.add(sum.remove(0));
        }
        for (int i = 0; i < 4; i++) {
            team3.add(sum.remove(0));
        }
        for (int i = 0; i < 4; i++) {
            team4.add(sum.remove(0));
        }
        //System.out.println(sum);
        System.out.println("第一组：" + team1);
        System.out.println("第二组：" + team2);
        System.out.println("第三组：" + team3);
        System.out.println("第四组：" + team4);
    }
}
