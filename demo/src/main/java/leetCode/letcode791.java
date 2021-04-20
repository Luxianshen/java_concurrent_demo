package leetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @desc：TODO
 * @date：2021/4/1 9:26 上午
 * @author：Lujs
 */
public class letcode791 {

    public static void main(String[] args) {
        String a = "kqep";
        String b = "pekeq";
        System.out.println(customSortString(a, b));
    }

    public static String customSortString(String S, String T) {

        //去重 输出
        byte[] a = S.getBytes();
        byte[] b = T.getBytes();
        int k =0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(a[i] == b[j]){
                    byte temp = b[j];
                    b[j] = b[k];
                    b[k] = temp;
                    k++;
                }
            }
            if(k >b.length-1){
                break;
            }
        }

        return new String(b);
    }
}
