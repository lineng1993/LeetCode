package dp.robotWalk;

/**
 * @author lin  2022/5/12 16:27
 * B站左神视频题目
 */
public class RobotWalk {


    public static void main(String[] args) {

        System.out.println(new RobotWalk().walkWays(5, 4 ,4, 2));
        System.out.println(new RobotWalk().dp(5, 4 ,4, 2));

    }

    /**
     *
     * @param n 总长度
     * @param p 目标位置
     * @param m 能走几步
     * @param k 初始位置
     * @return
     */
    public int walkWays(int n, int p, int m, int k){

        return f(n, p, m, k);
    }


    /**
     * 一共1-N个位置
     * @param n 位置数
     * @param p 目标位置
     * @param rest 剩余多少步
     * @param cur 当前位置
     * @return 到达方法数
     */
    private int f(int n, int p, int rest, int cur){

        /**
         * 存在的问题：大量重复计算, 其中n,p是固定值，那么 f(rest,cur)的值是可以使用记忆化搜索的
         * 那么dp[][] 的数组含义就比较明显了： 还剩几步，当前位置 有几种走法
         */
        if (rest == 0){
            return cur == p ? 1 : 0;
        }
        if (cur == 1){
            return f(n, p, rest - 1, 2);
        }
        if (cur == n){
            return f(n, p, rest - 1, n - 1);
        }
        return f(n, p , rest - 1, cur - 1) + f(n, p, rest - 1, cur + 1);
    }
    private int f1(int n, int p, int rest, int cur, int[][] dp){
        //携带缓存
        if (dp[rest][cur] != -1) return dp[rest][cur];
        if (rest == 0){
            dp[rest][cur] = cur == p ? 1:0;
            return dp[rest][cur];
        }
        if (cur == 1){
            dp[rest][cur] = f1(n, p, rest - 1, 2, dp);
        }else if (cur == n){
            dp[rest][cur] = f1(n, p, rest - 1, cur - 1, dp);
        }else {
            dp[rest][cur] = f1(n, p, rest - 1, cur - 1, dp) + f1(n, p, rest - 1, cur + 1, dp);
        }
        return  dp[rest][cur];
    }

    //画图理解
    private int dp(int n, int p, int rest, int cur){
        int[][] dp = new int[rest + 1][n + 1];
        /**
         * 初始值，对应 这句话
         * if (rest == 0){
         *             return cur == p ? 1 : 0;
         *         }
         */
        dp[0][p] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1){
                    dp[i][j] = dp[i - 1][j + 1];
                }else if(j == n){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
                System.out.println("dp[" + i + "][" + j + "]:" + dp[i][j]);
            }
        }
        return dp[rest][cur];
    }
}
