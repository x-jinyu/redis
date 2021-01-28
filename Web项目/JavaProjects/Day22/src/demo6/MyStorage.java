package demo6;

import java.util.ArrayList;
import java.util.List;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class MyStorage {
    private List list = new ArrayList();

    private static final int MAX = 10;  //仓库最大容量

    public void add(String data) {
        synchronized (list) {
            while (list.size() == MAX) {
                try {
                    //System.out.println(Thread.currentThread().getName());
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(data);
            System.out.println(Thread.currentThread().getName() + " 添加了数据: " + data + "后,仓库容量为: " + list.size());
            list.notifyAll();
        }
    }

    public void take(){
        synchronized (list){
            while (list.size() == 0){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Object remove = list.remove(0);
            System.out.println(Thread.currentThread().getName() + "取了数据:" + remove + "后, 仓库容量为: " + list.size());

            list.notifyAll();
        }
    }
}
