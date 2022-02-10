package dp.climbingStairs70;

/**
 * Easy
 * @author lin  2022/2/10 下午10:08
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(10));
        System.out.println(new ClimbingStairs().climbStairs2(10));
    }

    public int climbStairs(int n){
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairs2(int n){
        if (n < 3) return n;
        int a = 1, b = 2, r = 0;
        for (int i = 3; i <= n ; i++) {
           r = a + b;
           a = b;
           b = r;
        }
        return r;
    }

}
