package demo3;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class Test {
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        m1.getAdd(new Student("111", "张三", 18, 99.8));
        m1.getAdd(new Student("222", "李四", 19, 50));
        m1.getAdd(new Student("333", "王五", 22, 50));
        m1.getAdd(new Student("444", "呆呆", 30, 70));

        //m1.printArr();

        System.out.println(m1.findStudent("张三"));

        //m1.delStudent("222");
        m1.printArr();

        m1.sortScore();
        m1.printArr();
    }
}
