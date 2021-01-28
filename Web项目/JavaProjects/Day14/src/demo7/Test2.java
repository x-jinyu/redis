package demo7;

/**
 * 王金宇
 * 2020/10/13 0013
 */
public class Test2 {
    public static void main(String[] args) {
        Person[] arr = new Person[5];
        int size = 0;
        arr[size++] = new Person("张张", 18);
        arr[size++] = new Person("小花", 18);
        arr[size++] = new Person("呆呆", 18);

        int b = -1;
        for (int i = 0; i < size; i++) {
            //System.out.println(arr[i].name);
            if ("小花".equals(arr[i].name)) {
                b = i;
                break;
            }
        }
        if (b >= 0) {
            System.arraycopy(arr, b + 1, arr, b, arr.length - 1 - b);
            arr[size - 1] = null;
            //size--;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }

    }
}
