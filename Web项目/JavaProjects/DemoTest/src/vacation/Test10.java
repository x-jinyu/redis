package vacation;

/**
 * 王金宇
 * 2020/9/30 0030
 * 10. 定义一个方法判断一个数是否为回文素数. 回文素数指一个数同时为素数和回文数。
 *    如131是一个素数，同时也是一个回文数。编写程序，显示前100个回文素数，每行显示10个。
 */
public class Test10 {
    public static void main(String[] args) {
        /*Scanner input = new Scanner(System.in);
        System.out.println("输入一个数字以判断是否为回文素数");
        int num = input.nextInt();
        IsPrimePalindromes(num);*/
        int a = 0;
        int i = 2;
        while (true){
            if (a != 100){
                if (IsPrimePalindromes(i++)){
                    a++;
                    if (a % 10 == 0){
                        System.out.print("\t" + "\n");
                    }
                }
            }else {
                break;
            }
        }
    }

    public static boolean IsPrimePalindromes(int num) {
        if (Test09.prime(num)){
            if (Test05.order(num) == num){
                System.out.print(num + "\t");
                return true;
            }
        }
        return false;
    }
}
