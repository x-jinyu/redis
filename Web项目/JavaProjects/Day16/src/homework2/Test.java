package homework2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 王金宇
 * 2020/10/18 0018
 */
public class Test {
    public static void main(String[] args) {
        //(1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        while (list.size() < 10) {
            int num = random.nextInt(100);
            //System.out.println(random);       //测试是否是100以内的随机数
            if (!list.contains(num)) {
                list.add(num);
            }
            //System.out.println(list); //测试是否存储到了集合当中
        }
        //(2)遍历集合中的所有元素打印
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();

        //判断集合是否包含66
        System.out.println(list.contains(66));
        //删除集合中的77元素
        System.out.println(list.remove(new Integer(77)));

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next < 50) {     //删除集合小于50的整数
                iterator.remove();
            }
        }
        System.out.println("最终结果：" + list);

    }
}
