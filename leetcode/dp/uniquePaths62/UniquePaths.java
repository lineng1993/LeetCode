package dp.uniquePaths62;

/**
 * Medium
 * @author lin  2022/1/7 11:23
 */
public class UniquePaths {

    public static void main(String[] args) {


        new UniquePaths().uniquePaths(3,7);
    }


    /**
     * 思路：
     * 1. 确定dp数组（dp table）以及下标的含义
     * dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
     * 2. 确定递推公式
     * 想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来
     * 3. dp数组的初始化
     * 首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理。
     * for (int i = 0; i < m; i++) dp[i][0] = 1;
     * for (int j = 0; j < n; j++) dp[0][j] = 1;
     * 4. 确定遍历顺序
     * 这里要看一下递归公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，dp[i][j]都是从其上方和左方推导而来，那么从左到右一层一层遍历就可以了。
     */

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                System.out.println(String.format("dp[%s][%s]", i, j) + ":" + dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
