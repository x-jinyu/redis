package demo1;

import java.util.*;

/**
 * 王金宇
 * 2020/10/22 0022
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "xx", "yy", "aa", "dd", "mm", "qq", "jj");
        System.out.println(list);

        list.sort((String o1, String o2) -> o1.compareTo(o2));
        System.out.println(list);

        list.forEach((String s) -> System.out.println(s));

        Map<String, Integer> map = new HashMap<>();
        map.put("lisi", 8000);
        map.put("wangwu", 9000);
        map.put("zhaoliu", 5000);
        map.put("chenqi", 6000);
        map.put("zhangsan", 4000);
        map.put("feifei", 7000);

        /*map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+ ":" +integer);
            }
        });*/
        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
