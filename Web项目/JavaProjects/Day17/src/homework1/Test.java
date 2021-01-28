package homework1;

import java.util.*;

/**
 * 王金宇
 * 2020/10/19 0019
 */
public class Test {
    public static void main(String[] args) {
        String[] strs = {"12345", "67891", "123478933", "9876543", "67891", "123478933"};
        List<String> list = Arrays.asList(strs);
        System.out.println(list);

        for (String qq : list) {
            if (!list.contains(qq)){
                list.add(qq);
            }
        }

        //将list中重复元素删除
        Set<String> set = new HashSet(list);
        List<String> list1 = new ArrayList<>(set);
        System.out.println(list1);
        //set.addAll(list);
        //System.out.println(set);

        /*for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next);
        }
        for (Object o : set) {
            String str = (String)o;
            System.out.println(str);
        }*/
    }
}
