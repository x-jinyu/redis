package demo3;

import java.util.Random;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        for (int i = 0; i < 10; i++) {
            new WindowThread("窗口--" + i, ticket).start();
          }
    }
}

class WindowThread extends Thread {
    private Ticket ticket;

    public WindowThread(String name, Ticket ticket) {
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ticket) {
                if (!ticket.hasRemaining()) {
                    System.out.println("票买完");
                    return;
                }
                ticket.print();
            }
        }
    }
}

class Ticket {
    private int no;     //票号
    private static final int MAX = 130;     //最大票数

    //判断是否还有剩余票
    public boolean hasRemaining() {
        return no < MAX;
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + "出售车票--" + no);
        try {
            Thread.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        no++;
    }
}