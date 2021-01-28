package demo8;

/**
 * 王金宇
 * 2020/10/13 0013
 * 使用冒泡排序将数组内的值进行从小到大的排序
 */
public class Test3 {
    public static void main(String[] args) {
        //定义一个int数组
        int[] arry = {11,22,58,3,19,96,107,21};
        
        //使用冒泡排序进行从小到大输出
        for (int i = 1; i < arry.length; i++) { //外层循环控制进行多少次比较  //这个地方是重点 从1开始循环，根据数组的长度进行判断
            for (int j = 0; j < arry.length-i; j++) {   //内层循环控制进行比较    //j从0开始，即：下标，当数组长度减去外层循环i的值时，即为本次循环所求的对比次数
                if (arry[j] > arry[j +1]){  //对下标为j以及j+1的两个数进行比较
                    int temp = arry[j +1];  //将大的数放到数组后面，小的数放到前面
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
            }
        }
        //排序好之后遍历数组
        for (int i : arry) {
            System.out.println(i);
        }
    }
}
