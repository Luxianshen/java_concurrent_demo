package leetCode;

import java.util.Arrays;

/**
 * @author Lujs
 * @desc TODO
 * @date 2021/9/9 11:27 上午
 */
public class leetcode322 {


    //https://leetcode-cn.com/problems/coin-change
    public static void main(String[] args) {

        int target1 = 1;
        int[] data1 = {1, 2, 5};


        System.out.println(coinChange2(data1, target1));

    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {

        //base case
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        //dp的定义 从开始到目前 最少到硬币数 0-amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


    public static int coinChange(int[] coins, int amount) {

        int[] sit = new int[coins.length];
        Arrays.fill(sit, 0);
        int length = coins.length - 1;
        //计算范围 最小值
        int min = amount / coins[length] + 1;
        sit[0] = min;

        if (amount % coins[length] == 0) return min - 1;
        int max = 0;
        for (int j = length; j >= 0; j--) {
            max += amount / coins[j];
            amount = amount % coins[j];
        }
        if (min == max) return max;
        System.out.println(min + " " + max);
        for (int i = min; i >= 0; i--) {


        }

        return 0;
    }

}
