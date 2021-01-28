package demo3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("D:/files/log.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
