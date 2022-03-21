package leetCode;

import java.util.*;

/**
 * @author Lujs
 * @desc TODO
 * @date 2021/9/14 4:53 下午
 */
public class leetcode787 {


    //https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
    public static void main(String[] args) {

        /**
         *          0
         *     100     500
         *    1    100    2
         */
        int n = 2;
        int[][] edges = {{0, 1, 2}};
        int src = 1;
        int dst = 0;
        int k = 0;
        System.out.println(findCheapestPrice1(n, edges, src, dst, k));
    }


    /**
     * 正序处理
     */
    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {

        k++;
        int length = Math.max(n,flights.length);
        int[][] memo = new int[length][3];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = -1;
            }
        }

        Map<Integer, List<int[]>> data = new HashMap<>();
        //处理数据
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int prise = flights[i][2];
            data.putIfAbsent(from, new ArrayList<>());
            data.get(from).add(new int[]{to, prise});
        }

        return dp1(data, k, src, dst, memo);

    }

    public static int dp1(Map<Integer, List<int[]>> data, int k, int src, int dst, int[][] memo) {

        //base case
        if (src == dst) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (memo[src][k] != -1) {
            return memo[src][k];
        }
        //继续递归到底
        int result = Integer.MAX_VALUE;
        if (data.containsKey(src)) {
            k--;
            for (int[] a : data.get(src)) {
                int soul = dp1(data, k, a[0], dst, memo);
                if (soul != -1) {
                    result = Math.min(result, soul + a[1]);
                    if (memo[src][k] == -1) memo[src][k] = result;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }


    /**
     * 动态规划
     * 状态转移方程
     * f(dst) = min{f(dst-1,k-1),f(dst,k)}
     * base case
     * 备忘录
     * 优化
     */
    private final static int dst = 2;
    private final static int src = 0;
    private static Map<Integer, List<int[]>> data = new HashMap<>();

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        k++;
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            // 记录谁指向该节点，以及之间的权重
            data.putIfAbsent(to, new LinkedList<>());
            data.get(to).add(new int[]{from, price});
        }

        return dp(dst, k);
    }

    public static int dp(int s, int k) {

        if (s == src) return 0;
        if (k == 0) return -1;

        int res = Integer.MAX_VALUE;

        if (data.containsKey(s)) {
            for (int[] a : data.get(s)) {
                int from = a[0];
                int prise = a[1];

                int soul = dp(from, k - 1);
                if (soul != -1) {
                    res = Math.min(res, soul + prise);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
