package demo2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test2 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("jj");
        collection.add("GG");
        collection.add("AA");
        collection.add("BB");
        collection.add("CC");
        collection.add("DD");
        System.out.println(collection);

        Iterator<String> iterator = collection.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        while (collection.contains("jj")){
            collection.remove("jj");
        }
        System.out.println(collection);

        for (Iterator<String> stringIterator = collection.iterator(); stringIterator.hasNext(); ) {
            String next = stringIterator.next();
            if ("GG".equals(next)){
                stringIterator.remove();
            }
        }
        System.out.println(collection);
    }
}
