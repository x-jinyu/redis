package demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 王金宇
 * 2020/10/24 0024
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (!"exit".equalsIgnoreCase(line)){
            System.out.println("输入的文字" + line);
            line = br.readLine();
        }
        br.close();
    }
}
