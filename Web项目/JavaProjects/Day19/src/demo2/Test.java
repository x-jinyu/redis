package demo2;

import java.lang.reflect.Field;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Test test3 = new Test();
        Field fieldArray[] = null;
        //1)每个类都有class属性, 不会执行静态代码块
        Class claxx = String.class;

        //2)每个对象都有getClass()方法,从Object类继承来的
        Class claxx2 = test3.getClass() ;
        String name = claxx2.getSimpleName();

        System.out.println(claxx2);
        System.out.println(name);
    }
}
