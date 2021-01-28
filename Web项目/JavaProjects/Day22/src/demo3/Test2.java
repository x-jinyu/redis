package demo3;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class Test2 {
    public static void main(String[] args) {
        MyValue myValue = new MyValue("lisi", "123");

        new Thread(new Runnable() {
            @Override
            public void run() {
                myValue.setData("wangwu","456");
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myValue.getData();
            }
        },"t2").start();
    }
}
