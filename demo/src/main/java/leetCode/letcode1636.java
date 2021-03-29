package leetCode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @desc：TODO
 * @date：2021/3/25 4:52 下午
 * @author：Lujs
 */
public class letcode1636 {

    public static void main(String[] args) {

        int[] a = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        frequencySort(a);
    }

    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map<Integer, List<Integer>> mapList = new HashMap<>();
        map.forEach((k, v) -> {
            if (mapList.containsKey(v)) {
                mapList.get(v).add(k);
                mapList.put(v, mapList.get(v));
            } else {
                List<Integer> listA = new ArrayList<>();
                listA.add(k);
                mapList.put(v, listA);
            }
        });


        int[] result = new int[nums.length];

        AtomicInteger a = new AtomicInteger(0);
        mapList.keySet().stream().sorted().forEach(x -> {
            mapList.get(x).stream().sorted(Comparator.reverseOrder()).forEach(y -> {
                for (int i = 0; i < x; i++) {
                    result[a.get()] = y;
                    a.getAndIncrement();
                }
            });
        });

        return result;
    }

}
