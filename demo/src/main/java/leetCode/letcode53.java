package leetCode;

import java.util.Arrays;

/**
 * @desc：动态规划
 * @date：2021/4/13 6:21 下午
 * @author：Lujs
 */
public class letcode53 {

    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(a));

    }


    public static int maxSubArray(int[] nums) {

        int result = 0;
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            result = Math.max(sum, result);
        }

        return result;
    }

}
