package demo6;

import java.util.Random;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class ProducerThread extends Thread{
    private MyStorage storage;

    public ProducerThread(String name,MyStorage storage){
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            int num = new Random().nextInt(100);
            storage.add(String.valueOf(num));
        }
    }
}
