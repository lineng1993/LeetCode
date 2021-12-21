package array.maxAreaOfIsland695;

/**
 * Medium
 */
public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {

        /*
         * 没有很好的思路：题解写的很好
         * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
         */

        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1){
                    int a = area(grid, r, c);
                    res = Math.max(a, res);
                }
            }
        }
        return res;
    }


    private int area(int[][] grid, int r, int c){
        if (!inArea(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0; //已经扫描过或者本身为0
        grid[r][c] = 2;
        return 1
                + area(grid, r - 1, c) //上
                + area(grid, r + 1, c) //下
                + area(grid, r, c - 1) //左
                + area(grid, r, c + 1);//右
    }

    private boolean inArea(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;
    }
}
