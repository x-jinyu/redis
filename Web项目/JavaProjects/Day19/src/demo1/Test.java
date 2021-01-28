package demo1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 王金宇
 * 2020/10/22 0022
 */
public class Test {
    public static void main(String[] args) {
        String urlText = "www.bjpowernode.com/register?name=feifei&age=26&interest=sing&interest=dance&interest=game";
        String[] split = urlText.split("[?=&]");
        Map<String, String[]> map = new HashMap<>();

        for (int i = 1; i < split.length; i += 2) {
            //System.out.println(split[i]);
            if (!map.containsKey(split[i])) {
                map.put(split[i], new String[]{split[i + 1]});
            }else {
                String[] strings = map.get(split[i]);
                strings = Arrays.copyOf(strings, strings.length+1);
                strings[strings.length - 1] = split[i + 1];
                map.replace(split[i],strings);
            }
        }

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        }
        /*Collection<String> name = new ArrayList<>();
        name.add("feifei");
        Collection<String> age = new ArrayList<>();
        age.add("26");
        Collection<String> interest = new ArrayList<>();
        interest.add("sing,dance,game");
        Map<String,Collection> map = new HashMap<>();

        map.put("name",name);
        map.put("age",age);
        map.put("interest",interest);
        System.out.println(map);*/


    }
}
