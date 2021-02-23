package leetCode;

/**
 * @desc：TODO
 * @date：2021/1/10 下午10:34
 * @author：Lujs
 */
public class sumListNode {

    public static void main(String[] args) {

        int a = -123;
        System.out.println(reverse(a));
    }


    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int mod;
        double result = 0;
        while (x > 0) {
            mod = x % 10;
            x = x / 10;
            result = result * 10 + mod;
        }


        if (flag) {
            result = -result;
        }
        if (result > 2147483647 || result < -2147483648) {
            return 0;
        }
        return (int)result;
    }

}
