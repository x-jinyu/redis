package demo3;

import java.util.Random;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class MyValue {
    private String name;
    private String password;

    public MyValue(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void getData() {
        System.out.println("name = " + name + ",password = " + password);
    }

    public void setData(String name,String password) {
        this.name = name;
        try {
            Thread.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }

}
