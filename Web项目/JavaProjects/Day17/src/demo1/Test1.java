package demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 王金宇
 * 2020/10/19 0019
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("xx");
        list.add("yy");
        list.add("xx");
        list.add("aa");
        list.add("yy");
        list.add("bb");
        list.add("aa");
        list.add("dd");

        /*ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            String next = stringListIterator.next();
            //System.out.println(next);
        }
        System.out.println();
        while (stringListIterator.hasPrevious()) {
            String previous = stringListIterator.previous();
            //System.out.println(previous);
        }
        System.out.println();
        while (stringListIterator.hasNext()) {
            String next = stringListIterator.next();
            if ("xx".equals(next)) {
                stringListIterator.set("XXX");   //元素是xx就修改为XXX
            } else if ("yy".equals(next)) {
                stringListIterator.remove();        //元素是yy就删除
            } else if ("dd".equals(next)) {
                stringListIterator.add("DD");     //元素是aa就再添加一个元素
            }
            //System.out.println(next);
        }
        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        List<String> subList = list.subList(0,3);
        System.out.println(subList);
        list.set(0, "dd");
        System.out.println(subList);
        System.out.println(list);*/

        /*Object[] objects = list.toArray();
        for (Object object : objects) {
            String str = (String)object;
            System.out.println(str);
        }*/

        String[] data = new String[list.size()];
        list.toArray(data);
        System.out.println(Arrays.toString(data));

        List<String> asList = Arrays.asList(data);
        System.out.println(asList);

        data[0] = "xy";
        System.out.println(asList);
        System.out.println(list);
    }
}
