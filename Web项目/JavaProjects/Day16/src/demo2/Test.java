package demo2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("Hell");
        collection.add(234);
        collection.add(new Date());
        System.out.println(collection);

        for (Object o : collection) {
            System.out.println(o);
        }
        collection.remove("Hell");
        System.out.println(collection);

        System.out.println(collection.contains("234"));

    }
}
