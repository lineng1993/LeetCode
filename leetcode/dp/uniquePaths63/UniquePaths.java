package dp.uniquePaths63;

/**
 * Medium
 * 与62题一样，区别是存在障碍
 * @author lin  2022/1/10 15:44
 */
public class UniquePaths {

    public static void main(String[] args) {


        int[][] grid = new int[1][2];
        int[] g = {0,0};
        grid[0] = g;
        System.out.println(new UniquePaths().uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        //这题思路与62题完全一样，区别是遇到障碍物的一格需要置为0
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] =  dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
