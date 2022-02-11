package dp.decodeWays91;

/**
 * Medium
 * 关联offer dp TranslateNum
 * @author lin  2022/2/10 下午7:21
 */
public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(new DecodeWays().numDecodings("1418"));

    }
    public int numDecodings(String s) {

        /**
         * f[i]=f[i−1],1⩽a≤9
         * f[i]=f[i−2],10⩽b⩽26
         * f[i]=f[i−1]+f[i−2],1⩽a≤9,10⩽b⩽26
         */
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
            System.out.println("dp[" + i + "]:" + f[i]);
        }
        return f[n];
    }
}
