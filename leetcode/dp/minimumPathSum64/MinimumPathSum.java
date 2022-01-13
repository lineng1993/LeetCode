package dp.minimumPathSum64;

import java.util.Arrays;

/**
 * Medium
 * 62,63,64 同一类的题
 * @author lin  2022/1/13 20:13
 */
public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        System.out.println(new MinimumPathSum().minPathSum(grid));

        int[][] grid2 = new int[2][3];
        grid2[0] = new int[]{1, 2, 3};
        grid2[1] = new int[]{4, 5, 6};
        System.out.println(new MinimumPathSum().minPathSum(grid2));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }
}
