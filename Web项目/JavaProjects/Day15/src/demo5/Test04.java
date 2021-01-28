package demo5;

/**
 * 王金宇
 * 2020/10/16 0016
 */
public class Test04 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("14ss");
        System.out.println(sb);
        sb.append("111");
        System.out.println(sb);
        sb.delete(0, 1);
        System.out.println(sb);
        sb.insert(0, "aaa");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
