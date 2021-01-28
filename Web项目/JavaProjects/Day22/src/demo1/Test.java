package demo1;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test {
    public static void main(String[] args) {
        Thread t = new SubThread();
        SubThread t1 = new SubThread();

        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main --" + i);
        }
    }
}

class SubThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("方法里的---" + i);
        }
    }
}
