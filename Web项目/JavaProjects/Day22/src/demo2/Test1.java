package demo2;

/**
 * 王金宇
 * 2020/10/27 0027
 */
public class Test1 {
    static int num = 0;

    private static final Object OBJ = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //synchronized (OBJ){
                        num++;
                    //}
                }
            }
        };

        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(num);
    }
}
