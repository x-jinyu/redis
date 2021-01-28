package demo1;

/**
 * 王金宇
 * 2020/10/22 0022
 */
public class Test2 {
    public static void main(String[] args) {
        String urlText = "www.bjpowernode.com/register?name=feifei&age=26&interest=sing&interest=dance&interest=game";
        String[] split = urlText.split("[?=&]");
    }
}
