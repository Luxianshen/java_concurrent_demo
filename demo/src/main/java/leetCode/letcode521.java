package leetCode;

/**
 * @desc：TODO
 * @date：2021/3/30 3:06 下午
 * @author：Lujs
 */
public class letcode521 {

    public static void main(String[] args) {

        String a = "swoegxvzsfetrdtnoucawucug";
        String b = "gaqrzczpmtsxlwxdacitrcgklziiya";

        System.out.println(findLUSlength(a, b));
    }

    public static int findLUSlength(String a, String b) {

        byte[] aa = a.trim().getBytes();
        byte[] bb = b.trim().getBytes();
        if (aa.length == 0 ||bb.length == 0) return Math.max(aa.length,bb.length);
        //判断长度
        byte[] max;
        byte[] min;
        if (aa.length >= bb.length) {
            max = aa;
            min = bb;
        } else {
            max = bb;
            min = aa;
        }

        if (aa.length == bb.length) {
            if (aa[0] != bb[0]) {
                return aa.length;
            }
            return -1;
        }
        //指针平移
        for (int i = 0; i < max.length - min.length; i++) {
            if (max[i] == min[0] && max[min.length - 1] == min[min.length - 1]) {
                int count = 1;
                for (int j = i; j < min.length - 1; j++) {
                    if (max[i + j] == min[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == min.length - 1 - i) return Math.max(i, max.length - min.length - i);
            }
        }
        return max.length;

    }

}
