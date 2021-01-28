package demo5;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class Test2 {
    static int num = 0;
    private static final Object OBJ = new Object();
    private static final int THREADCOUNTS = 3;

    public static void main(String[] args) {
        for (int i = 0; i < THREADCOUNTS; i++) {
            int r = i;
            new Thread(new Runnable() {
                @Override   //打印偶数的线程
                public void run() {
                    printNum(r);
                }
            }).start();
        }
    }

    public static void printNum(int b) {
        for (int i = 0; i < 100; i++) {
            synchronized (OBJ) {
                while (num % THREADCOUNTS != b) {
                    try {
                        OBJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "---------" + num);
            num++;
            synchronized (OBJ) {
                OBJ.notifyAll();
            }
        }
    }
}
