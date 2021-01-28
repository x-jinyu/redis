package demo5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        /*Date date = new Date();
        System.out.println(date);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        long time = date.getTime();
        System.out.println(time);

        Date date1 = new Date(time + 1000 * 60 * 10);
        System.out.println(date1);
        date1 = new Date(1000);
        System.out.println(date1);
        date1 = new Date(-1000);
        System.out.println(date1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS z");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
*/
        String txt = "2020年10月16日 15:08:40";
        SimpleDateFormat another = new SimpleDateFormat("yyyy年M月dd日 H:mm:ss");
        Date date2 = another.parse(txt);
        System.out.println(date2);
    }
}
