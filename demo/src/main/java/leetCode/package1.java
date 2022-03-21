package leetCode;

import java.util.Arrays;

/**
 * @author Lujs
 * @desc TODO
 * @date 2021/9/13 3:03 下午
 */
public class package1 {

    public static void main(String[] args) {
        int[] data1 = {2, 2, 4, 6, 3};
        int target = 9;
        System.out.println(getMax1(data1, target));
    }


    public static int getMax1(int[] nums, int sum){
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i-1]) {
                    // 两种选择的结果之和
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int getMax(int[] nums, int target) {

        int length = 0;
        //排序
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (target >= nums[i] + dp[j - 1]) {
                    dp[i] = nums[i] + dp[j - 1];
                    length = Math.max(dp[i], dp[i - 1]);
                    break;
                }
            }

        }

        return length;

    }
}
