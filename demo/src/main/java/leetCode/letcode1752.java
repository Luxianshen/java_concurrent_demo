package leetCode;

/**
 * @desc：检查数组是否经排序和轮转得到
 * @date：2021/4/19 9:25 下午
 * @author：Lujs
 */
public class letcode1752 {

    public static void main(String[] args) {
        int[] a = new int[]{6,4,7,1,3};
        int[] b = new int[]{2, 1, 3, 4};
        System.out.println(check(a));
    }


    public static boolean check(int[] a) {

        if (a.length == 0) return false;
        if (a.length == 1) return true;

        //双指针两边遍历
        int left = a.length - 1 >>> 1;
        int right = left + 1;
        //3 4 5 1 2
        int count1 = a[left] > a[right] ? 1:0;
        int count2 = 0;
        while (left > 0) {
            if (a[left] < a[left - 1]) {
                count1++;
            }
            if (right < a.length-1 && a[right] > a[right + 1]) {
                count2++;
            }
            if (count1 + count2 > 1) return false;
            left--;
            right++;
        }
        if(count1 + count2 == 0) return true;
        else return a[0] > a[a.length-1];

    }

}
