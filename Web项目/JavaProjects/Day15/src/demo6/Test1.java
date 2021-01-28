package demo6;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test1 {
    public static void main(String[] args) {
        /*DecimalFormat df = new DecimalFormat("###,###.0000");
        double dd = 123131323.2222;
        String ss = df.format(dd);
        System.out.println(ss);
        System.out.println(df.format(33333.1));*/

        float f = 123456.123456F;
        System.out.println(f);
        f = 132133.789789f;
        System.out.println(f);

        BigInteger integer1 = new BigInteger("7894651984651384651894651846951368451368513");
        BigInteger integer2 = new BigInteger("46597846598746598465198465168453");
        BigInteger integer3 = integer1.add(integer2);
        System.out.println(integer3);
        System.out.println(integer1.subtract(integer2));
        System.out.println(integer1.multiply(integer2));
        System.out.println(integer1.divide(integer2));

        BigDecimal d1 = new BigDecimal("7894659874658974651684516845.789465");
        BigDecimal d2 = new BigDecimal("746513987465.7984");
        System.out.println(d1.divide(d2,20, RoundingMode.HALF_EVEN));
    }
}
