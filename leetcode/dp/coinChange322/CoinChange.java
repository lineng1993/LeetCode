package dp.coinChange322;

import java.util.Arrays;

/**
 * Medium
 * @author lin  2021/12/28 19:26
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        /**
         * DP入门题：本题和背包问题
         */
        //存放对应amount的最优解
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {  //i 是面额
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
