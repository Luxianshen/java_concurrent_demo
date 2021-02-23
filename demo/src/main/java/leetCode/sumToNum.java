package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc：TODO
 * @date：2021/1/10 下午10:07
 * @author：Lujs
 */
public class sumToNum {

    public static void main(String[] args) {
        int[] a = new int[]{2,7,9,11};
        int target = 18;
        int[] result = findIndex(a, target);
        System.out.println(result[0]+";;;"+result[1]);
    }

    private static int[] findIndex(int[] a, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int one = target - a[i];
            if(map.containsKey(one)){
                return new int[]{map.get(one),i};
            }
            map.put(a[i],i);
        }
        return null;
    }
}
