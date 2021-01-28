package demo1;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class Test1 {
    public static void main(String[] args) {
        int[] data = {11, 22, 33, 44, 55, 66, 77, 88};

        System.out.println(binarySeach(data, 11));
    }

    /**
     * @param data 输入的数组
     * @param key  需要查找的值
     * @return 返回这个值的下标,如果不存在就返回-1
     */
    public static int binarySeach(int[] data, int key) {
        int from = 0;               //起始位置
        int to = data.length - 1;   //结束位置
        int mid = (from + to) / 2;  //中间位置

        while (from <= to) {
            //始终与中间值做比较
            //如果中间值与需要查找的值相等，直接返回中间值下标
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] > key) {
                //把查找范围缩小至左面一半
                to = mid - 1;
                //重新计算中间值
                mid = (from + to) / 2;
            }else if (data[mid]<key){
                from = mid + 1;
                mid = (from + to) /2;
            }
        }
        return -1;
    }

}
