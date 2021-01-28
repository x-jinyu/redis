package demo3;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 王金宇
 * 2020/10/19 0019
 */
public class Test1 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet1 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        treeSet1.add(new Student("李四",90));
        treeSet1.add(new Student("张三",90));
        treeSet1.add(new Student("王五",90));
        treeSet1.add(new Student("赵六",90));


        System.out.println(treeSet1);

        TreeSet<Student> treeSet2 = new TreeSet<>();
        treeSet2.addAll(treeSet1);
        System.out.println(treeSet2);
    }
}
