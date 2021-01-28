package demo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/files/obj.txt"));
        System.out.println(ois.readObject());
        ois.close();
    }
}
