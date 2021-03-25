package leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @desc：TODO
 * @date：2021/3/18 4:51 下午
 * @author：Lujs
 */
public class letcode1710 {


    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7},{3,9}};
        int a = maximumUnits(boxTypes, 10);
        System.out.println(a);
    }

    static int maximumUnits(int[][] boxTypes, int truckSize) {

        //箱子为0
        if (truckSize == 0) return truckSize;
        Map<Integer, Integer> map = Arrays.stream(boxTypes).collect(Collectors.toMap(x -> x[0], x -> x[1]));
        int needSize = map.values().stream().mapToInt(integer -> integer).sum();
        //箱子足够多
        if (truckSize > needSize) return map.entrySet().stream().mapToInt(x -> x.getKey() * x.getValue()).sum();
        //箱子不够
        Stream<Integer> sortMap = map.keySet().stream().sorted();
        Integer sum = 0;

        List<Integer> aa = new ArrayList<>();
        List<Integer> bb = new ArrayList<>();
        bb.add(truckSize);
        sortMap.forEach(x -> {
                    if (bb.get(0) >= map.get(x)) {
                        aa.add(x * map.get(x));
                        bb.set(0, bb.get(0) - map.get(x));
                    } else {
                        aa.add(x * bb.get(0));
                        bb.set(0,0);
                        return;
                    }
                }
        );

        for (Integer a:aa) {
            sum += a;
        }
        return sum;
    }

}
