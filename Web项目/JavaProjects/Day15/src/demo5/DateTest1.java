package demo5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class DateTest1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH：mm：ss");
        String ss = now.format(dtf);
        System.out.println(ss);

        String txt = "2020年10月16日15:08:40";
        DateTimeFormatter another = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(txt, another);
        System.out.println(parse);
    }
}
