package demo2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test3 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aa");
        collection.add("bb");
        collection.add("cc");
        System.out.println(collection);//[aa, bb, cc]

        Collection<String> collection1 = new ArrayList<>(collection);
        System.out.println(collection1);//[aa, bb, cc]

        Collection<String> collection2 = new ArrayList<>();
        System.out.println(collection2);
        collection2.addAll(collection1);
        System.out.println(collection2);

        collection2.add("xx");
        collection2.add("yy");
        collection2.add("zz");
        System.out.println(collection2);
        collection2.removeAll(collection);
        System.out.println(collection2);

        collection2.addAll(collection1);
        System.out.println(collection2);

        collection2.retainAll(collection1);
        System.out.println(collection2);

    }
}
