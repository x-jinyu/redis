package homework1;

import java.util.Arrays;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test3 {
    public static void main(String[] args) {
        String txt = "101,lisi,99;202,wangwu,78;303,chenqi,86;404,zhaosi,42;505,feifei,18";

        Student[] data = new Student[20];
        int size = 0;   //用于记录数组下标
        String[] split = txt.split("[,;]");////使用regex正则表达式分割当前字符串.返回分割后子串组成的数组

        //遍历split数组,每次从数组中取三个数组元素, 即当i==0时, 取split[i], split[i+1],split[i+2]这三个元素创建Student对象
        for (int i = 0; i < split.length; i +=3) {
            //System.out.println(split[i]);
            Student s = new Student(split[i], split[i + 1], Integer.valueOf( split[i+2] ));
            //把stu存储到data数组中, 一般情况下,向数组中添加元素前确定数组容量足够大
            if ( size == data.length){
                data = Arrays.copyOf(data, data.length * 2);
            }
            data[size++] = s;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}
