package demo1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
* 王金宇
*2020/10/24 0024
*/

public class Test2 {
    public static void main(String[] args) throws IOException {
        Person p = new Person("张三", 25);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/files/obj.txt"));
        oos.writeObject(p);
        oos.close();
    }
}
