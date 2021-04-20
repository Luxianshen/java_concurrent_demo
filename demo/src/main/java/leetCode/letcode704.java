package leetCode;

/**
 * @desc：二分查找
 * @date：2021/4/13 6:10 下午
 * @author：Lujs
 */
public class letcode704 {

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(getIndex(a, target));
    }

    public static int getIndex(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;

    }

}
