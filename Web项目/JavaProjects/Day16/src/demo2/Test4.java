package demo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.contains("aa"));

        for (String s : list) {
            System.out.println(s);
        }

        list.remove("aa");
        System.out.println(list);

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if ("cc".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(list);

        list.add(0,"aa");
        list.add(3, "ss");
        System.out.println(list);

        String remove = list.remove(1);
        System.out.println(list);
        System.out.println(remove);

        System.out.println(list.indexOf("ss"));
        System.out.println(list.lastIndexOf("aa"));

        System.out.println(list.get(0));
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
