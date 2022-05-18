package dp.fibonacciNumber509;

/**
 * Easy
 * @author lin  2022/1/6 17:04
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(new FibonacciNumber().fib3(10, new int[11]));
        System.out.println(new FibonacciNumber().fib(10));

    }

    public int fib(int n) {

        /**
         * DP入门题，也可以递归
         */
        // 1. dp公式  dp[n] = dp[n - 1] + dp[n-2];
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            System.out.println("dp[" + i + "]:" + dp[i]);
        }
        return dp[n];
    }

    public int fib2(int n) {

        /**
         * 状态压缩，只需要2个值即可
         */
        // 1. dp公式  dp[n] = dp[n - 1] + dp[n-2];
        if (n < 2) return n;
        int p = 0, q = 1, r = 0;
        for (int i = 2; i <= n; i++) {
           r = p + q;
           p = q;
           q = r;
        }
        return r;
    }

    public int fib3(int n, int[] dp) {

        /**
         * 只跟 n 有关：改记忆化搜索
         */
        // 1. dp公式  dp[n] = dp[n - 1] + dp[n-2];

        /**
         * 一维dp表，只跟前面2位有关系，很好改写成fib了
         */
        if (n < 2) {
            dp[n] = n;
            return n;
        }
        int f1 = dp[n - 1];
        int f2 = dp[n - 2];
        if (f1 == 0){
            dp[n - 1] = fib3(n - 1, dp);
        }
        if (f2 == 0){
            dp[n - 2] = fib3(n -2, dp);
        }
        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }
}
