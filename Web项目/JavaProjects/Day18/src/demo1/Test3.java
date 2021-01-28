package demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * 王金宇
 * 2020/10/20 0020
 */
public class Test3 {
    public static void main(String[] args) {
        String txt = "aldsjkflajdsflj";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < txt.length(); i++) {
            //System.out.println(i);
            char c = txt.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }else {
                Integer old = map.get(c);
                map.put(c,++old);
            }
        }
        /*for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() +"出现次数"+entry.getValue());
        }*/
        System.out.println(map);
    }
}
