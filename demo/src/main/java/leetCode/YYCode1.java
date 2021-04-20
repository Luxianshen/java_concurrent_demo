package leetCode;

import java.util.*;

/**
 * @desc：TODO
 * @date：2021/4/2 5:37 下午
 * @author：Lujs
 */
public class YYCode1 {


    public static void main(String[] args) {

        int[] a = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] b = new int[]{1, 2, 8, 6, 4};
        int[] c = new int[]{2, 1, 8, 6, 9,10,3,4,5,6};
        LIS(a);
        LIS(b);
        LIS1(c);
        //1,3,4,8,9
    }

    public static int LIS1(int[] nums) {

        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }


    public static int[] LIS(int[] arr) {

        //判空
        if (arr.length == 0) return new int[0];
        Map<Integer, List<Integer>> map = new HashMap<>();

        int max = 1;
        int index;
        int now;
        //滑动窗口
        for (int i = 0; i < arr.length; i++) {
            now = 1;
            index = i;
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[index] < arr[j]) {
                    //交换值 index 和 j
                    list.add(arr[j]);
                    index = j;
                    now++;
                } else {
                    if(list.get(0) < arr[j]){
                        list.add(arr[j]);
                    }
                }
            }
            //判断是否要存起来
            max = Math.max(max, now);
            if (max == now) {
                map.put(map.size() + 1, list);
            }

        }

        //判断一下 那个max更好即可
        return null;
    }

}
