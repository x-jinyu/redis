package demo1;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Test1 {
    public static void main(String[] args) {
        int i = Integer.parseInt("123");
        Integer i1 = new Integer(123);
        Integer i2 = new Integer(1);
        byte bb = i1.byteValue();
        System.out.println(bb);
        System.out.println(i1.compareTo(i2));

        System.out.println(Integer.compare(123,1155));
        System.out.println(Double.compare(131, 11));
        System.out.println(Character.compare('a', 'b'));

        Integer integer = Integer.valueOf(123);
        System.out.println(integer.compareTo(123));
    }
}
