package demo3;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class Test {
    public static void main(String[] args) {
        Catapult c = new Catapult();
        Fly brid = new BlackBrid();
        c.sling(brid);
        brid = new BlueBrid();
        c.sling(brid);
        brid = new YellowBrid();
        c.sling(brid);
        brid = new RedBrid();
        c.sling(brid);
    }
}
