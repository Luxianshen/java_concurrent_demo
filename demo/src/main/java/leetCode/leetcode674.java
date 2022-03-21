package leetCode;

/**
 * @author Lujs
 * @desc deal
 * @date 2021/9/6 9:33 下午
 */
public class leetcode674 {

    //https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
    public static void main(String[] args) {

        int[] data = {1, 3, 5, 4, 7};
        int[] data1 = {2, 2, 2, 2, 2, 2, 2};
        int[] data2 = {1, 3, 5, 4, 2, 3, 4};
        int[] data3 = {1, 3, 5, 4, 2, 3, 4, 5};
        int[] data4 = {2, 1};
        int[] data5 = {2, 1, 3};
        int[] data6 = {1, 2};
        int[] data7 = {2};

        System.out.println(findLengthOfLCIS(data));
        System.out.println(findLengthOfLCIS(data1));
        System.out.println(findLengthOfLCIS(data2));
        System.out.println(findLengthOfLCIS(data3));
        System.out.println(findLengthOfLCIS(data4));
        System.out.println(findLengthOfLCIS(data5));
        System.out.println(findLengthOfLCIS(data6));
        System.out.println(findLengthOfLCIS(data7));

    }


    public static int findLengthOfLCIS(int[] nums) {

        int arrLength = nums.length;
        int length = 1;
        //游标
        int fast = 0;
        int last = 0;

        for (int i = 1; i < arrLength; i++) {

            fast = i;
            if (nums[i] <= nums[i - 1]) {
                length = Math.max(length, fast - last);
                last = i;
            } else if (i + 1 == arrLength && nums[i] > nums[i - 1]) {
                fast += 1;
            }
        }


        if (last == 0 && arrLength > 0) {
            return Math.max(length, fast - last);
        } else {
            return Math.max(length, fast - last);
        }

        //return length;
    }

}
