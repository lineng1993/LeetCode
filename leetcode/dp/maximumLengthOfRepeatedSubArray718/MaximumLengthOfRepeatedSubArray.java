package dp.maximumLengthOfRepeatedSubArray718;


/**
 * Medium
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class MaximumLengthOfRepeatedSubArray {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,2,1};
        int[] num2 = {3,2,1,4,7};
        System.out.println(new MaximumLengthOfRepeatedSubArray().findLength(num1, num2));
    }


    public int findLength(int[] nums1, int[] nums2) {

        /**
         * 1:确定dp数组（dp table）以及下标的含义
         * dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
         * 2:确定递推公式
         * 根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
         *
         */

        int aLen = nums1.length;
        int bLen = nums2.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        int res = 0;
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    System.out.printf("dp[%d][%d]:%d\n", i, j, dp[i][j]);
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
