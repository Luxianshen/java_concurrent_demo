package leetCode;

/**
 * @author Lujs
 * @desc deal
 * @date 2021/9/10 4:06 下午
 */
public class leetcode27 {


    //https://leetcode-cn.com/problems/remove-element/
    public static void main(String[] args) {

        int[] data1 = {3, 2, 2, 3};
        int[] data2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] data3 = {4, 5};
        int[] data4 = {5, 5};

        int val1 = 3;
        int val2 = 2;
        int val3 = 4;
        System.out.println(removeElement(data1, val1));
        System.out.println(removeElement(data2, val2));
        System.out.println(removeElement(data3, val3));
        System.out.println(removeElement(data4, 5));

    }


    //双指针
    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return val == nums[0] ? 0 : 1;

        int length = nums.length;

        int count = 0;
        int last = nums.length - 1;

        //最后一个不处理
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                //交换值
                count++;
            }
        }


        return length - count;

    }


}
