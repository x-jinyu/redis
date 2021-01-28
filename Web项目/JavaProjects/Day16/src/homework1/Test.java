package homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test {
    public static void main(String[] args) {
        //创建Collection集合,存储Student对象
        Collection<Student> collection = new ArrayList<>();

        //向集合中添加5个Student对象
        collection.add(new Student("张三", 58));
        collection.add(new Student("李四", 68));
        collection.add(new Student("王五", 78));
        collection.add(new Student("赵六", 88));
        collection.add(new Student("陈七", 98));

        //判断集合中是否包含指定的Student对象
        System.out.println(collection.contains(new Student("李四", 68)));
        /*Iterator<Student> studentIterator = collection.iterator();
        while (studentIterator.hasNext()) {
            Student next = studentIterator.next();
            if ((new Student("李四", 68).equals(next))) {
                System.out.println("存在该学生对象");
            }
        }*/

        //判断集合中是否包含指定姓名的同学
        boolean b = false;
        for (Iterator<Student> iterator = collection.iterator(); iterator.hasNext(); ) {
            Student next = iterator.next();
            if (next.getName().contains("李a四")) {
                b = true;
            }
        }
        if (b){
            System.out.println("存在该学生");
        }else {
            System.out.println("不存在该学生");
        }
        /*Iterator<Student> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getName().contains("张三")) {
                System.out.println("存在该学生");
            }
        }*/

        //删除集合中成绩小于60的同学
        for (Iterator<Student> iterator = collection.iterator(); iterator.hasNext(); ) {
            Student next = iterator.next();
            if (next.getScore() < 60) {
                iterator.remove();
                System.out.println("已删除该学生");
            }
        }
        System.out.println(collection);
        /*Iterator<Student> iter = collection.iterator();
        while (iter.hasNext()) {
            Student next = iter.next();
            if (next.getScore() < 60) {
                iter.remove();
                System.out.println("存在该学生");
            }
        }*/
    }
}
