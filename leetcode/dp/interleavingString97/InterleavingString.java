package dp.interleavingString97;

/**
 * Medium
 */
public class InterleavingString {

    public static void main(String[] args) {

        String s1 = "bacc", s2 = "aabcce", s3 = "abaacbccec";
        System.out.println(new InterleavingString().isInterleave(s1,s2,s3));
    }


    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length(), len = s3.length();
        if (m + n != len) return false;

        //然后呢。。。
        //题解思路：动态规划
        /* https://leetcode-cn.com/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
         * 1. 递归数组和含义 dp[i][j] 表示 s1 前i + s2 前 j 能否组成 s3的前i+j
         *
         */
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++) dp[0][j] = true; // 不相符直接终止

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n ; j++) {

                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }

        return dp[m][n];
    }
}
