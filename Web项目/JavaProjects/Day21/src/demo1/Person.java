package demo1;

import java.io.Serializable;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 2680088500101139649L;
    String name;
    int age;
    String gender;
    String personId;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }
}
