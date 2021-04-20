package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @desc：TODO 未解
 * @date：2021/4/1 10:54 上午
 * @author：Lujs
 */
public class letcode1387 {

    public static void main(String[] args) {
        System.out.println(101%10);
        System.out.println(getKth(1, 1000, 777));
    }

    public static int getKth(int lo, int hi, int k) {

        //计算权重 放进map
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i < hi - lo +1; i++) {
            int initNum = lo + i;
            int start = lo + i;
            int runTime = 0;
            while (start > 1) {
                if (start % 2 == 0) {
                    start = start / 2;
                } else {
                    start = start * 3 + 1;
                }
                runTime++;
            }
            result.put(initNum, runTime);
        }

        List<Integer> collect = result.values().stream().sorted().collect(Collectors.toList());
        System.out.println(collect.get(k));
        return 0;

    }
}
