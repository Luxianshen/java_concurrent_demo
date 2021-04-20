package leetCode;

import java.util.Arrays;

/**
 * @desc：TODO
 * @date：2021/3/17 5:17 下午
 * @author：Lujs
 */
public class YYCode {

    public static void main2(String[] args) {
        int[] a = new int[]{1, 2, 13, 12, 11, 9, 11, 12, 13};

        int maxMax = 0;
        int max = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                max++;
            } else {
                maxMax = Math.max(max, maxMax);
                max = 1;
                if (maxMax > a.length - i) {
                    break;
                }
            }
        }
        maxMax = Math.max(max, maxMax);
        System.out.println(maxMax);
    }


    public static void main(String[] args) {
        System.out.println(change(1316));
    }

    /**
     * 找零钱 最少数量
     * 期望 5块是1张 8块是2张
     */
    public static int change(int num) {

        int[] a = new int[]{1, 2, 4, 5, 10};
        //1 2 3 4 5 6 7 8 9 10
        int result = 0;
        if (num > 10) {
            result += num / 10;
            while (num > 10) {
                num = num % 10;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                return result + 1;
            } else if (num < a[i]) {
                return result + 2;
            }
        }
        return 0;
    }


    public static void main1(String[] args) {
        int out = 0;
        int[] a = new int[]{1, 0, 1};

        System.out.println(aaa(a));
    }

    static int aaa(int[] a) {
        if (a.length == 1 || a[0] != a[1]) return a[0];
        if (a[a.length - 1] != a[a.length]) return a[a.length];
        Arrays.sort(a);
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] != a[i] && a[i] != a[i + 1]) {
                System.out.println(a[i]);
                return a[i];
            }
        }
        return 0;
    }

}
