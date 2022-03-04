package dp.maximumProductSubarray152;

/**
 * Medium
 * @author lin  2022/3/4 14:32
 */
public class MaximumProductSubarray {


    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};
        System.out.println(new MaximumProductSubarray().maxProduct(nums));

    }

    public int maxProduct(int[] nums) {
        //错误原因：当前位置的最优解未必是由前一个位置的最优解转移得到的。
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] * nums[i]);
        }
        return dp[n - 1];
    }

    public int maxProduct2(int[] nums) {
        //正数和负数分开处理：正数 * 正数，负数 * 负数，
        int n = nums.length;
        int[] dpMax = new int[n]; //处理正数
        int[] dpMin = new int[n]; //遇到负数处理负数的数组
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {

            /*
             * 当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
             * 当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
             * 当dpMin[i-1] < 0，dpMax[i] = dpMin[i-1] * nums[i]
             * 当dpMin[i-1] >= 0，dpMax[i] = nums[i]
             * 整体有三种取值：dpMax[i-1] * nums[i]，dpMin[i-1] * nums[i]，nums[i
             */
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i] /*nums[i] < 0 */, Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i]/*nums[i] < 0 */, nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    public int maxProduct3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }


}
