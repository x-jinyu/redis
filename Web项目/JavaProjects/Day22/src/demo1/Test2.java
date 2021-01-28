package demo1;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Prime());
        t.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t2的线程" + i);
                }
            }
        });
        t2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main方法中线程" + i);
        }
    }
}

class Prime implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("prime线程" + i);
        }
    }
}
