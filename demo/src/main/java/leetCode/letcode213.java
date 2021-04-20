package leetCode;

import java.util.Arrays;

/**
 * @desc：TODO
 * @date：2021/4/15 10:28 上午
 * @author：Lujs
 */
public class letcode213 {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 1};
        int[] b = new int[]{1, 2, 1, 1};
        int[] c = new int[]{2, 3, 2};
        int[] d = new int[]{5, 4, 1, 3, 5, 100, 101};
        int[] e = new int[]{200, 3, 140, 20, 10};
        int[] f = new int[]{2, 1, 1, 2};
        int[] g = new int[]{2,2,4,3,2,5};
        int[] h = new int[]{7,7,9,5,5,10};
        int[] j = new int[]{8,4,8,5,9,6,5,4,4,10};


        /*System.out.println(rob(a));
        System.out.println(rob(b));
        System.out.println(rob(c));
        System.out.println(rob(d));
        System.out.println(rob(e));
        System.out.println(rob(f));
        System.out.println(rob(g));
        System.out.println(rob(h));*/
        System.out.println(rob(j));

    }

    public static int rob(int[] a) {

        if (a.length == 1) return a[0];
        if (a.length == 2) return Math.max(a[0], a[1]);
        if (a.length == 3) return Math.max(a[2], Math.max(a[0], a[1]));
        if (a.length == 4) return Math.max(a[0] + a[2], a[3] + a[1]);

        int len = a.length;

        //奇数处理 砍头砍尾
        int j = 0;
        if (a.length % 2 != 0) {
            //未位比首位大
            if (a[a.length - 1] > a[0]) {
                j = 1;
            } else {
                //首位比末位大
                len = a.length - 1;
            }
        } else {
            //最后一位的问题
            if(a[a.length-1] + a[1] > a[a.length-2] + a[0]){
                j = 1;
            }
        }

        int[] b = new int[len];
        Arrays.fill(b, 0);

        b[j] = a[j];
        b[j+1] = Math.max(a[j], a[j + 1]);
        b[j+2] = Math.max(a[j + 1], a[j] + a[j + 2]);

        for (int i = 3 + j; i < len; i++) {
            b[i] = Math.max(b[i - 1], Math.max(b[i - 3], b[i - 2]) + a[i]);
        }

        return Math.max(b[b.length - 2], b[b.length - 1]);
    }

}
