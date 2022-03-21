package leetCode;

/**
 * @author Lujs
 * @desc deal
 * @date 2021/9/14 10:26 上午
 */
public class leetcode64 {

    //https://leetcode-cn.com/problems/minimum-path-sum/
    public static void main(String[] args) {

        /**
         * 1 3 1
         * 1 5 1
         * 4 2 1
         */
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * todo 优化
     */
    public static int minPathSumMax(int[][] grid) {
        //阶段最优
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];

        
       return 0;
    }

    /**
     * 动态规划
     * 递归 备忘录  f(i,j) = min{f(i-1,j),f(i,j-1)}
     * base case
     * 状态转移方程
     * 优化
     */
    public static int minPathSum(int[][] grid) {

        /*int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];*/

        int[][] mm = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                mm[i][j] = -1;
            }
        }

        return getMin(grid, grid.length - 1, grid[0].length - 1, mm);

    }

    private static int getMin(int[][] grid, int x, int y, int[][] mm) {

        //base case
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        //备忘录
        if (mm[x][y] != -1) {
            return mm[x][y];
        }

        int now = Math.min(getMin(grid, x, y - 1, mm), getMin(grid, x - 1, y, mm)) + grid[x][y];

        if (mm[x][y] == -1) {
            mm[x][y] = now;
        }
        return now;
    }

}
