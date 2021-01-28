package demo2;

/**
 * 王金宇
 * 2020/10/15 0015
 */
public class demo3 {
    public static void main(String[] args) {
        int[][] arr = new int[5][3];
        int[][] arr1 = {
                {1, 2, 3, 4},
                {1, 1, 2, 3},
                {44, 55, 6, 7}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
