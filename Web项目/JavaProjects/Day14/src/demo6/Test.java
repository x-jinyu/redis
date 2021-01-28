package demo6;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test {
    public static void main(String[] args) {
        int[] arry = getArry(10);

        printIntArry(arry);
    }

    public static void printIntArry(int[] arry) {
        for (int i : arry) {
            System.out.println(i);
        }
    }

    //通过传递参数确定数组长度
    public static int[] getArry(int temp) {
        int[] num = new int[temp];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100);
        }
        /*for (int i : num) {
            num[i] = (int)(Math.random()*100);
            System.out.println(num[i]);
        }*/
        return num;
    }
}
