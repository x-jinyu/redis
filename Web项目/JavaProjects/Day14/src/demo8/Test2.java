package demo8;

/**
 * 王金宇
 * 2020/10/13 0013
 * 定义方法,实现int[]数组元素的乱序
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arry = {11,22,33,44,55,66,77,88,99,10};
        shuffle(arry);
        printArry(arry);
    }

    private static void printArry(int[] arry) {
        for (int i : arry) {
            System.out.println(i);
        }
    }

    private static void shuffle(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            //System.out.println(arry[i]);
            int x = (int)(Math.random() * arry.length);//x为随机数
            //System.out.println(temp);

            //将随机的这个数做为一个下标，将i下标与x下标内的值进行置换，得出乱序输出数组内容
            int temp = arry[i];
            arry[i] = arry[x];
            arry[x] = temp;
        }
    }
}
