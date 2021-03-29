package leetCode;

/**
 * @desc：TODO
 * @date：2021/3/25 4:13 下午
 * @author：Lujs
 */
public class letcode1025 {

    public static void main(String[] args) {

        System.out.println(divisorGame(2));
    }

    public static boolean divisorGame(int N) {
// 4 1 1  2 1 1  3 2 1 1
        //1-1000 x
        int k = 1;
        while (N > 1) {
            N = N - 1;
            k++;
        }

        return k % 2 == 0;
    }

}
