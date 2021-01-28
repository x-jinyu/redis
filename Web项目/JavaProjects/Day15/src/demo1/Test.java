package demo1;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class Test {
    public static void main(String[] args) {
        int[] data = {11, 2, 5, 1, 8, 64};

        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = min + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (min != i){
                int t = data[i];
                data[i] = data[min];
                data[min] = t;
            }
        }
        for (int datum : data) {
            System.out.println(datum);
        }
    }
}
