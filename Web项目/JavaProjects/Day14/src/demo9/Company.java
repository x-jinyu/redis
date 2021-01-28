package demo9;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Company {
    private Employee[] data;
    private int size;

    //无参构造
    public Company() {
        data = new Employee[100];
    }

    public Company(int capacity) {
        if (capacity < 0) {
            data = new Employee[100];
        } else {
            data = new Employee[capacity];
        }
    }

    //添加员工的方法，让emp参数传递的员工
    public void getAdd(Employee emp) {
        if (size > data.length) {  //判断该数组的长度是否足够，如果size大于data.length，代表长度不够，使用Arrays.copyOf方法进行扩容
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = emp;     //把对象保存到数组中，并且让长度自动增加一次，为下一次添加新员工做准备
    }


    /**
     * 该方法判断指定姓名的员工是否存在
     *
     * @param name 输入需要判断的员工姓名
     * @return true代表存在，否则不存在
     */
    public boolean judgeEmp(String name) {
        //指定员工姓名以进行判断
        /*if (name != null) {
            for (int i = 0; i < size; i++) {
                if (name.equals(data[i].getName())) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].getName() == null) {
                    return true;
                }
            }
        }
        return false;*/
        return indexOf(name) >= 0;

    }

    /**
     * 该方法删除指定姓名的员工
     *
     * @param name 输入需要删除的员工姓名
     */
    public void delEmp(String name) {
        int index = indexOf(name); //确定需要删除的员工在数组中的下标
        if (index < 0) {
            System.out.println("公司中不存在姓名为" + name + "的员工");
            return;
        }
        System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
        data[size] = null;
        size--;
    }

    /**
     * @param name 输入员工姓名
     * @return 返回这个员工的数组下标
     */
    public int indexOf(String name) {
        if (name != null) {
            for (int i = 0; i < size; i++) {
                if (name.equals(data[i].getName())) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].getName() == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    //定义方法,根据员工的年龄升序排序
    public void sortByAge() {
        Arrays.sort(data, 0, size, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();       //o1年龄大返回正数,对应升序
            }
        });
    }

    //定义方法,根据员工的工资降序排序
    public void sortBySalary() {
        Arrays.sort(data, 0, size, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o2.getSalary() > o1.getSalary()) {
                    return 1;
                } else if (o2.getSalary() == o1.getSalary()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    //遍历数组打印员工信息，在员工类中重写了toString()方法
    public void printEmp() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}

