package leetCode;

import java.util.Arrays;

/**
 * @author Lujs
 * @desc TODO
 * @date 2021/9/6 2:38 下午
 */
public class leetcode1406 {


    //https://leetcode-cn.com/problems/stone-game-iii/
    public static void main(String[] args) {

        int[] data = {1, 2, 3, 7};

        //stoneGameIII(data);
        int[] a = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] b = new int[]{1, 2, 8, 6, 4};
        int[] c = new int[]{2, 1, 8, 6, 9, 10, 3, 4, 5, 6};
        test(a);
        test(b);
        test(c);

    }


    /**
     * 区间
     * 1 <= values.length <= 50000
     * -1000 <= values[i] <= 1000
     * <p>
     * 规则 总数大 赢
     * 均负数或相等 平局
     */
    public static String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            //由于有负值分数，这里注意一下
            dp[i] = Integer.MIN_VALUE;
            sum += stoneValue[i];
            for (int j = i; j < i + 3 && j < n; j++) {
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        int alice = dp[0];
        int bob = sum - dp[0];
        if (alice == bob) return "Tie";
        if (alice > bob) return "Alice";
        return "Bob";

    }


    public static void test(int[] a) {
        int max = 9;


        int[] dp = new int[a.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }

        System.out.println(dp);
    }

}
