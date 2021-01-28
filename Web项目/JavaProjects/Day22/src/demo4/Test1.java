package demo4;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class Test1 {
    public static void main(String[] args) {
        Subthread ta = new Subthread();
        ta.setName("a");
        ta.start();

        Subthread tb = new Subthread();
        tb.setName("b");
        tb.start();
    }
}
