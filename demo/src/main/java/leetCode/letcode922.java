package leetCode;

/**
 * @desc：按奇偶排序数组 II
 * @date：2021/4/20 4:21 下午
 * @author：Lujs
 */
public class letcode922 {

    public static void main(String[] args) {
        int[] a = new int[]{648,831,560,986,192,424,997,829,897,843};
        sortArrayByParityII(a);
    }

    public static int[] sortArrayByParityII(int[] A) {

        int n = A.length;
        int[] ans = new int[n];

        int i = 0;
        for (int x : A) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : A) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;

    }

}
