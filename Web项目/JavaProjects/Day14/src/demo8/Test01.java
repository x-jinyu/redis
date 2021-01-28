package demo8;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test01 {
        public static void main(String[] args) {
            //调用getArray(int)方法,把方法返回值赋值给一个变量
            int [] array = getArray(50);

            //调用printIntArray(int[])方法把数组元素打印到屏幕上
            printIntArray( array );

        }

        //定义方法,把int[]整数数组所有元素打印到屏幕上,需要通过参数接收一个int[]类型的数组
        public static void printIntArray( int [] array){
            for (int x : array) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        //定义方法, 通过参数来接收数组的大小, 返回指定长度的整数数组
        public static int []  getArray( int capacity){
            //根据参数接收的容量创建存储整数的数组
            int [] data = new int[capacity];
            //给data数组元素赋值[0,100)范围内的随机整数
            for (int i = 0; i < data.length; i++) {
                data[i] =  (int)(Math.random()*100);
            }
            //返回data, 方法返回值类型就是data的类型: int[]
            return data;
        }
}
