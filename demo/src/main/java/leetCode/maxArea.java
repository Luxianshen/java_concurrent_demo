package leetCode;

import java.util.Arrays;

/**
 * @desc：最大面积
 * @date：2021/1/22 下午10:04
 * @author：Lujs
 */
public class maxArea {

    public static void main1(String[] args) {
        int[] a = new int[]{1, 2, 1};
        //要算 x y
        //最大x 最大y
        // x = m-n
        // y = yn 或者 ym
        //以x为距离 取两个最大的y中的小
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            int temp = i * getMax(a, i);
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);

    }

    private static int getMax(int[] c, int x) {
        int maxY = 0;
        int n = 0;
        int m = 0;
        //次数 x
        for (int i = 0; i < c.length - x; i++) {
            int temp = c[i] + c[i + x];
            if (temp > maxY) {
                maxY = temp;
                n = i;
                m = i + x;
            }
        }
        return c[n] > c[m] ? c[m] : c[n];
    }


    public static void main2(String[] args) {
        //取中位数 和上面的位置算
        int[] a = new int[]{1, 6, 2, 5, 4, 8, 3, 7,5,8,9,2,3};
        // 25431
        //if (a.length == 2)
        //return a[0]>a[1]?a[1]:a[0];
        int k = 0;
        int max = 0;
        for (int i = 1; i < a.length; i++) {

            int maxY = 0;
            int n = 0;
            int m = 0;
            //次数 x
            for (int j = 0; j < a.length - i; j++) {
                int temp = a[j] * a[j + i];
                if (temp >= maxY && j * (j + i) >= n * m) {
                    maxY = temp;
                    n = j;
                    m = j + i;
                }
                k++;
            }
            if (i == a.length - 1)
                m = a.length - 1;
            int temp = i * (a[n] > a[m] ? a[m] : a[n]);
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        System.out.println(k);
    }

    public static void main(String[] args) {
        //取次大值
        int[] a = new int[]{1, 6, 2, 5, 4, 8, 3, 7,5,8,9,2,5};

        int[] b = a.clone();
        Arrays.sort(b);
        int k = 0;

        int max = (a.length-1) * (a[0] > a[a.length-1] ? a[a.length-1] : a[0]);
        for (int i = a.length - 1; 0 < i; i--) {

            if (max < i * b[b.length/2]) {
                //次数 x
                for (int j = 0; j < a.length - i; j++) {
                    int temp = i * (a[j] > a[j+i] ? a[j+i] : a[j]);
                    if (temp > max) {
                        max = temp;
                    }
                    k++;
                }
            }
        }
        System.out.println(k);
        System.out.println(max);
    }
}
