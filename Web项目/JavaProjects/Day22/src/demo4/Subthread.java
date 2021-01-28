package demo4;

/**
 * 王金宇
 * 2020/10/29 0029
 */
public class Subthread extends Thread{
    @Override
    public void run() {
        if ("a".equals(Thread.currentThread().getName())){
            synchronized ("资源1"){
                System.out.println("a线程获得了资源1，完成任务还需要申请资源2");
                synchronized ("资源2"){
                    System.out.println("a线程获得了资源1与资源2，可以完成任务了");
                }
            }
        }

        if ("a".equals(Thread.currentThread().getName())){
            synchronized ("资源2"){
                System.out.println("b线程获得了资源1，完成任务还需要申请资源2");
                synchronized ("资源1"){
                    System.out.println("b线程获得了资源1与资源2，可以完成任务了");
                }
            }
        }
    }


}

