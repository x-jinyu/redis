package homework1;

/**
 * 王金宇
 * 2020/10/16 0016
 * 定义方法实现字符串逆序
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        String str = "123";
        str = "abcd";
        System.out.println(t.reverse(str));
    }
    public String reverse(String i){
        StringBuilder str = new StringBuilder(i);
        str.reverse();
        return str.toString();
    }
}
