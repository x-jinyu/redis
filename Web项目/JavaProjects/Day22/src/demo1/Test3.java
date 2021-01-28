package demo1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 王金宇
 * 2020/10/26 0026
 */
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new PrimeC());
        Thread t = new Thread(task);

        t.start();

        System.out.println(task.get());
    }
}

class PrimeC implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int num = new Random().nextInt(100);
        System.out.println("子线程任务执行结束，结果为：" + num);
        return num;
    }
}
