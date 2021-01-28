package vacation;

/**
 * 王金宇
 * 2020/9/30 0030
 * 求1+2!+3!+...+10!的和，尝试调用第2题的方法
 */
public class Test11 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            sum += Test02.factorial(i);
        }
        System.out.println(sum);
    }
}
