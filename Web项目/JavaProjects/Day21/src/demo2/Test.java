package demo2;

import java.io.FileReader;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test {
    public static void main(String[] args) {
        //m1();
        m2();

    }

    private static void m2() {
        try (FileReader fr = new FileReader("D:\\JavaProjects\\Day21\\src\\demo2\\Test.java")) {

            char[] chars = new char[1024 * 8];
            int read = fr.read(chars);
            while (read != -1) {
                System.out.print(String.valueOf(chars, 0, read));
                read = fr.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void m1() throws IOException {
        String path = "D:\\JavaProjects\\Day21\\src\\demo2\\Test.java";
        FileReader fr = new FileReader(path);

        int read = fr.read();
        while (read != -1) {
            System.out.print((char) read);
            read = fr.read();
        }
        fr.close();
    }
}
