package demo1;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println("11-------" + Thread.activeCount());
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("sub thread " + i);
                }
            }
        });

        System.out.println("22------" + Thread.activeCount());
        System.out.println(t.isAlive());
        t.start();
        System.out.println("33------" + Thread.activeCount());
        System.out.println(t.isAlive());
    }
}
