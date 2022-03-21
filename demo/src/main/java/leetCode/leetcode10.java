package leetCode;

/**
 * @author Lujs
 * @desc TODO
 * @date 2021/9/13 4:54 下午
 */
public class leetcode10 {


    public static void main(String[] args) {

        int n = 10;
        System.out.println(fib(n));

    }

    public static int fib(int n) {

        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 2; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return sum;
    }
}
