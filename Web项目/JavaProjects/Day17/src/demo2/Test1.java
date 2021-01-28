package demo2;

import java.util.LinkedList;

/**
 * 王金宇
 * 2020/10/19 0019
 */
public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("xx");
        linkedList.add("aa");
        linkedList.add("zz");
        linkedList.add("hh");
        //System.out.println(linkedList);
        linkedList.remove("aa");
        /*System.out.println(linkedList);
        System.out.println(linkedList.contains("xx"));
        System.out.println(linkedList.size());

        for (String s : linkedList) {
            System.out.println(s);
        }
        for (Iterator<String> iterator = linkedList.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
        }*/

        linkedList.add(1, "ss");
        System.out.println(linkedList);

        System.out.println(linkedList.get(linkedList.size() - 1));

        linkedList.offer("dd");
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);

        System.out.println(linkedList.peek());
        System.out.println(linkedList);

        linkedList.offerFirst("ff");
        linkedList.offerLast("ii");
        System.out.println(linkedList);

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList);

        linkedList.push("aa");//模拟入栈, 把元素aa添加到链表的头部
        System.out.println(linkedList);//[aa, ff, ss, zz, hh, dd, ii]
        System.out.println(linkedList.pop());//aa
        System.out.println(linkedList);//[ff, ss, zz, hh, dd, ii]
    }
}
