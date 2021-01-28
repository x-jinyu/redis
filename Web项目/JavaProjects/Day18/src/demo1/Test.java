package demo1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 王金宇
 * 2020/10/20 0020
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 8000);
        map.put("李四", 9000);
        map.put("王五", 5000);
        map.put("赵六", 6000);

        System.out.println(map);

        Integer old = map.put("张三", 7000);
        System.out.println(map);
        System.out.println(old);

        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsKey("王"));
        System.out.println(map.containsValue(9000));
        System.out.println(map.containsValue(10000));

        System.out.println(map.get("李四"));
        System.out.println(map.get("1"));

        old = map.replace("张三", 123);
        System.out.println(map);
        System.out.println(old);

        old = map.replace("sss", 111);
        System.out.println(map);
        System.out.println(old);
        old = map.remove("ss");
        System.out.println(map);
        System.out.println(old);
        old = map.remove("张三");
        System.out.println(map);
        System.out.println(old);
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        Collection<Integer> values = map.values();
        System.out.println(values);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);
        boolean remove1 = keySet.remove("李四");
        System.out.println(remove1);
        System.out.println(keySet);
        System.out.println(map);

        boolean remove = values.remove(123);
        System.out.println(remove);
        System.out.println(values);
        System.out.println(map);

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey()  + " " + entry.getValue());
        }
    }
}
