package leetCode;

import java.util.*;

/**
 * @desc：TODO
 * @date：2021/4/8 4:20 下午
 * @author：Lujs
 */
public class letcode179 {

    public static void main(String[] args) {
        int[] a = new int[]{10, 2};
        int[] b = new int[]{432, 43243};
        System.out.println(largestNumber(b));
        System.out.println("test");
    }

    /**
     * 权重设计问题 3 3 30 6 300
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 109
     */
    public static String largestNumber(int[] nums) {


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                //3 30 31 34 33
                if (compare(nums[i], list.get(j))) {
                    list.add(j, nums[i]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(nums[i]);
            }
        }

        String result = "";
        for (Integer integer : list) {
            result += integer;
        }
        return result.startsWith("0") ? "0" : result;
    }

    public static boolean compare(int a, int b) {
        String order1 = a + "" + b;
        String order2 = b + "" + a;

        return Long.parseLong(order1) > Long.parseLong(order2);
    }


}
