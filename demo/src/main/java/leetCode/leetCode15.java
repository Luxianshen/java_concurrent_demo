package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Lujs
 * @desc TODO
 * @date 2022/1/10 5:42 PM
 */
public class leetCode15 {

    public static void main(String[] args) {

        int[] data = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSumNum(data);

    }

    private static List<List<Integer>> threeSumNum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int L = 0;
        int R = nums.length - 1;
        while (L < R){
            int cur = R -1;



        }
        for (int i = 0; i < nums.length; i++) {
            //双向收缩  -4 -1 -1 0 1 2

        }

        return result;
    }


}
