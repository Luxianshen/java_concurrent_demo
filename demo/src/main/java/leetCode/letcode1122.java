package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @desc：TODO
 * @date：2021/3/23 2:11 下午
 * @author：Lujs
 */
public class letcode1122 {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] b = new int[]{2, 1, 4, 3, 9, 6};
        int[] c = test(a,b);
        System.out.println();
    }

    public static int[]  test(int[] a, int[] b) {

        int[] c = new int[a.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        int k = 0;
        for (int i = 0; i < b.length; i++) {
            int run = map.get(b[i]);
            for (int j = 0; j < run; j++) {
                c[k] = b[i];
                k++;
            }
            map.remove(b[i]);
        }

        if(map.isEmpty()){
            return c;
        }

        List<Integer> aa = new ArrayList<>(map.keySet());
        Collections.sort(aa);
        for (Integer m:aa) {
            int run = map.get(m);
            for (int j = 0; j < run; j++) {
                c[k] = m;
                k++;
            }
        }
        return c;

    }




}
