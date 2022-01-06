package dp.fibonacciNumber509;

/**
 * Easy
 * @author lin  2022/1/6 17:04
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(new FibonacciNumber().fib2(10));
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
}
