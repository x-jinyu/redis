package demo2;

import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class Test3 {
    public static void main(String[] args) {
        Person[] arr = new Person[10];
        int size = 0;
        arr[size++] = new Person("zhang张", 18);
        arr[size++] = new Person("li李", 19);
        arr[size++] = new Person("dai呆", 20);
        arr[size++] = new Person("di滴", 18);

        for (Person person : arr) {
            System.out.println(person);
        }

        Arrays.sort(arr, 0, size);
        System.out.println("升序");
        for (Person person : arr) {
            System.out.println(person);
        }

        /*Arrays.sort(arr, 0, size, new Comparator<Person>() {  // 从上至下升序排序
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age > o2.age) {
                    return 1;
                } else if (o1.age == o2.age) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (Person person : arr) {
            System.out.println(person);
        }

        Arrays.sort(arr, 0, size, new Comparator<Person>() {    //从上至下降序排序
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age > o2.age){
                    return -1;
                }else if (o1.age == o2.age){
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        for (Person person : arr) {
            System.out.println(person);
        }*/

        /*Arrays.sort(arr, 0, size, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;  //从上至下升序排序
            }
        });

        for (Person person : arr) {
            System.out.println(person);
        }*/
        /*Arrays.sort(arr, 0, size, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age; //从上至下 降序排序
            }
        });
        for (Person person : arr) {
            System.out.println(person);
        }*/
    }
}
