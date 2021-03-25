package leetCode;

import java.util.*;
import java.util.stream.Stream;

/**
 * @desc：三数之合
 * @date：2021/3/5 3:56 下午
 * @author：Lujs
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,2};
        List<List<Integer>> result = threeSuma(nums);
        System.out.println(result);
    }


    public static  List<List<Integer>> threeSuma(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        // sort
        Arrays.sort(nums);
        // 3 foreach
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t = -nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > t) {
                    k--;
                } else if (nums[j] + nums[k] < t) {
                    j++;
                } else {
                    // find
                    List<Integer> ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    result.add(ans);
                    // 去除临近相同的元素
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) return new ArrayList<>();
        //正负数据
        int zeroTime = 0;
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int x : nums) {
            if (x == 0) zeroTime++;
            if (x > 0) {
                if (mapA.containsKey(x)) {
                    mapA.put(x, mapA.get(x) + 1);
                } else {
                    mapA.put(x, 1);
                }
            } else if(x <0){
                if (mapB.containsKey(-x)) {
                    mapB.put(-x, mapB.get(-x) + 1);
                } else {
                    mapB.put(-x, 1);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        if (zeroTime >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            result.add(temp);
            return result;
        }
        if (mapA.isEmpty() || mapB.isEmpty()) return new ArrayList<>();

        // 1 1 2 或者 2 1 1 或者有 1 0 1
        final boolean has = zeroTime > 0;

        Set<String> set = new HashSet<>();
        // 11 2
        // 2 11
        // 12 3
        // 3 21
        mapA.forEach((k, v) -> {
            mapB.forEach((n, m) -> {
                if(k-n>0){
                    Integer tempKey = k - n;
                    if (mapB.containsKey(tempKey)) {
                        List<Integer> temp = new ArrayList<>();
                        if (tempKey.intValue() != n.intValue()) {
                            String tempSet = Math.min(n, tempKey) + "" + Math.max(n, tempKey) + k;
                            if (!set.contains(tempSet) && tempKey != 0) {
                                temp.add(Math.min(-n, -tempKey));
                                temp.add(Math.max(-n, -tempKey));
                                temp.add(k);
                                result.add(temp);
                                set.add(tempSet);
                            }
                        } else {
                            if (mapB.get(n) > 1) {
                                String tempSet = n + "" + n + "" + k;
                                if (!set.contains(tempSet)) {
                                    temp.add(-n);
                                    temp.add(-n);
                                    temp.add(k);
                                    result.add(temp);
                                    set.add(tempSet);
                                }
                            }
                        }
                    }
                }else {
                    Integer tempKey = n - k;
                    if (mapA.containsKey(tempKey)) {
                        List<Integer> temp = new ArrayList<>();
                        if (tempKey.intValue() != k.intValue()) {
                            String tempSet = -n + "" + Math.min(tempKey,k) + Math.max(tempKey,k);
                            if (!set.contains(tempSet) && tempKey != 0) {
                                temp.add(-n);
                                temp.add(tempKey);
                                temp.add(k);
                                result.add(temp);
                                set.add(tempSet);
                            }
                        } else {
                            if (mapA.get(k) > 1) {
                                String tempSet = -n + "" + k + "" + k;
                                if (!set.contains(tempSet)) {
                                    temp.add(-n);
                                    temp.add(k);
                                    temp.add(k);
                                    result.add(temp);
                                    set.add(tempSet);
                                }
                            }
                        }
                    }
                }

            });
            if (has && mapB.containsKey(k)) {
                String tempSet = k + "";
                if (!set.contains(tempSet)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(-k);
                    temp.add(0);
                    temp.add(k);
                    result.add(temp);
                    set.add(tempSet);
                }
            }
        });
        return result;
    }

}
