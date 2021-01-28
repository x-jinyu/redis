package demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 王金宇
 * 2020/10/23 0023
 */
public class Test {
    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

        map.put("金宇", "支棱起来");
        map.put("老夏", "支棱起来");
        map.put("阿波", "支棱起来");
        list.add(map);

        map = new HashMap<>();
        map.put("金宇", "支棱起来");
        map.put("老夏", "支棱起来");
        map.put("阿波", "支棱起来");
        list.add(map);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            map = list.get(i);
            int count = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey()+ ":"+ entry.getValue());
                count++;
                if (count<map.size()){
                    sb.append(",");
                }
                //sb.append("\n");
            }
            if (i < list.size()){
                sb.append("。\n");
            }
        }
        System.out.println(sb);
    }
}
