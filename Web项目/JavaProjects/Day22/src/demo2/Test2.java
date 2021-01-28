package demo2;

/**
 * 王金宇
 * 2020/10/27 0027
 */
public class Test2 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test2.sm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test2.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test072.sm();
            }
        }).start();
    }

    public static void sm(){
        synchronized (Test2.class){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
        }
    }

    public static void mm(){
        synchronized (Test2.class){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
        }
    }
}

class Test072{
    public static void sm(){
        synchronized (Test2.class){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
            }
        }
    }
}
