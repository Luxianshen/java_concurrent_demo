package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc：TODO
 * @date：2021/4/6 2:25 下午
 * @author：Lujs
 */
public class letcode300 {

    public static void main(String[] args) {

        int[] a = new int[]{4, 10, 4, 3, 8, 9}; //3
        int[] b = new int[]{0, 1, 0, 3, 2, 3}; //4
        int[] c = new int[]{5, 7, -24, 12, 13, 2, 3, 12, 5, 6, 35}; //6
        int[] d = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}; //6
        int[] e = new int[]{10, 9, 2, 5, 3, 7, 200, 18, 101, 102, 103};//7
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS(b));
        System.out.println(lengthOfLIS(c));
        System.out.println(lengthOfLIS(d));
        System.out.println(lengthOfLIS(e));
    }

    public static int lengthOfLIS(int[] arr) {

        //判空
        if (arr.length == 0) return 0;

        int max = 1;
        int index;
        int now;
        int a = 0;
        //滑动窗口
        for (int i = 0; i < arr.length; i++) {
            a++;
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
                    //第一个不删除
                    if (list.size() > 1) {
                        //换值
                        list.remove(list.size() - 1);
                        list.add(arr[j]);
                        index = j;
                    }
                }
            }
            //判断是否要存起来
            max = Math.max(max, now);
            if (max > arr.length - i) {
                break;
            }
        }
        //判断一下 那个max更好即可
        return max;
    }

}
