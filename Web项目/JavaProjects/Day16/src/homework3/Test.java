package homework3;

/**
 * 王金宇
 * 2020/10/14 0014
 */
public class Test {
    public static void main(String[] args) {
        Company c1 = new Company();
        c1.getAdd(new Employee("111", "李李", 18, 1800));
        c1.getAdd(new Employee("222", "lisi", 22, 2000));
        c1.getAdd(new Employee("333", "aa", 19, 1111));
        c1.getAdd(new Employee("444", "bb", 21, 2002));
        c1.printEmp();
        System.out.println(c1.judgeEmp("aaa"));

        //c1.delEmp("李李");
        //c1.printEmp();

        c1.sortByAge();

        /*Company c1 = new Company(); //创建公司对象

        c1.getAdd(new Employee("111", "李李", 20, 2000));
        c1.getAdd(new Employee("222", "lisi", 18, 1800));
        c1.getAdd(new Employee("333", "aa", 17, 4000));
        c1.getAdd(new Employee("444", "bb", 16, 1900));

        c1.getAdd(new Employee());
        c1.getAdd(new Employee());

        c1.printEmp();

        System.out.println(c1.judgeEmp("lisi"));

        System.out.println(c1.judgeEmp(null));
        while (c1.judgeEmp(null)) {
            c1.delEmp(null);
        }

        //c1.printEmp();

        c1.sortByAge();
        c1.printEmp();
        c1.sortBySalary();
        c1.printEmp();*/
        //c1.storeEmp(emp);   //默认公司只有三个人
        //c1.printEmp(emp);   //测试打印输出数组  //方法正确

        //将创建好的员工对象插入数组中,默认将员工插入至第一个数组值内
       /*Employee[] emp1 = c1.getEmp(emp, 0, new Employee("111", "李李", 20, 2222));
        Employee[] emp2 = c1.getEmp(emp1, 0, new Employee("222", "lisi", 20, 2222));
        Employee[] emp3 = c1.getEmp(emp2, 0, new Employee("333", "aa", 20, 2222));
        Employee[] emp4 = c1.getEmp(emp3, 0, new Employee("444", "bb", 20, 2222));
        Employee[] emp5 = c1.getEmp(emp4, 0, new Employee("555", "cc", 20, 2222));
        Employee[] emp6 = c1.getEmp(emp5, 0, new Employee("666", "dd", 20, 2222));
        Employee[] emp7 = c1.getEmp(emp6, 0, new Employee("777", "ff", 20, 2222));
        Employee[] emp8 = c1.getEmp(emp7, 0, new Employee("888", "ee", 20, 2222));
        Employee[] emp9 = c1.getEmp(emp8, 0, new Employee("999", "ss", 20, 2222));
        Employee[] emp10 = c1.getEmp(emp9, 0, new Employee("000", "ww", 20, 2222));*/
        /*c1.printEmp(emp10); //将插入好数据的数组输出
        System.out.println(c1.judgeEmp(emp10, "张三"));   //判断是否存在zhangsan
        c1.delEmp(emp10, "lisi");*/
        //c1.printEmp(emp10);  //将lisi删除,调用方法打印输出整个数组内容


    }
}
