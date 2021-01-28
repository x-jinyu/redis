package demo3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class MyClass {
    private Student[] data;     //定义学生类数组用来储存信息
    private int size;               //定义size计数器，用来计算数组中的元素数量

    public MyClass() {
        data = new Student[5];
    }

    public MyClass(int num) {
        if (num < 0) {
            data = new Student[5];
        } else {
            data = new Student[num];
        }
    }

    /**
     * 该方法是将对象的信息储存在数组当中
     *
     * @param student 将student对象传递到数组中
     */
    public void getAdd(Student student) {
        if (size == data.length) {  //判断数组容量是否足够
            data = Arrays.copyOf(data, data.length * 2);    //容量不足将进行数组扩容
        } else {
            data[size++] = student;
        }
    }

    /**
     * 该方法进行遍历数组内所有信息
     */
    public void printArr() {
        for (Student datum : data) {
            System.out.println(datum);
        }
    }

    /**
     * 查找是否有指定姓名的学生在数组当中
     *
     * @param name 通过name确定该学生姓名
     */
    public boolean findStudent(String name) {
        if (name != null) {
            for (int i = 0; i < size; i++) {
                if (name.equals(data[i].getName())) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].getName().equals(null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定学号的学生
     *
     * @param id 输入id用以删除该学生
     */
    public void delStudent(String id) {
        int index = -1;
        if (id != null) {
            for (int i = 0; i < size; i++) {
                if (id.equals(data[i].getId())) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].getName().equals(null)) {
                    index = i;
                }
            }
        }
        if (index >= 0) {
            System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
            data[--size] = null;
        } else {
            System.out.println("班级内不存在学号为" + id + "的学生");
        }
    }

    //对学生根据成绩降序排序,成绩一样根据学号升序排序
    public void sortScore() {
        Arrays.sort(data, 0, size, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.getScore() > o1.getScore()) {
                    return 1;
                } else if (o2.getScore() == o1.getScore()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

}
