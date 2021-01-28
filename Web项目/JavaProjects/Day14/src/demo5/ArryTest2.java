package demo5;

/**
 * 王金宇
 * 2020/10/12 0012
 */
public class ArryTest2 {
    public static void main(String[] args) {
        char[] chars = new char[100];
        int a = 0;

        for (int i = 1, j = 'a'; i <= 26; i++, j++) {
            a = getA(chars, j);
            System.out.println((char) j + "在循环中出现了" + a + "次");
        }
    }

    //返回小写字母a在循环中出现几次
    public static int getA(char[] chars, int x) {
        int a = 0;
        for (int i = 0; i < 100; i++) {
            getRandom(chars, i);
            if (chars[i] == x) {
                a++;
            }
        }
        return a;
    }

    //取得一个随机的小写字母
    public static void getRandom(char[] chars, int i) {
        double d = Math.random();
        int x = (int) (d * 26);
        char c = (char) ('a' + x);
        chars[i] = c;
    }
}
