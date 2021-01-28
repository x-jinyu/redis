package demo6;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test02 {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};
        System.out.println(getString(intArr));
    }

    private static String getString(int[] intArr) {
        String str = "";
        for (int i = 0; i < intArr.length; i++) {
            str += intArr[i];
            if (i < intArr.length - 1) {
                str += ",";
            }
        }
        return str;
    }
}