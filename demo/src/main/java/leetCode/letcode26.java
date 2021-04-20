package leetCode;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @desc：TODO
 * @date：2021/3/29 8:39 下午
 * @author：Lujs
 */
public class letcode26 {

    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        int num = 1;
        for (int i = 0 ; i < nums.length -1; i++) {
            if(nums[i] != nums[i+1]){
                nums[num] = nums[i+1];
                num++;
            }
        }
        return num;
    }

}
