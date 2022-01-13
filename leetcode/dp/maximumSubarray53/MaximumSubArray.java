package dp.maximumSubarray53;


/**
 * Easy
 */
public class MaximumSubArray {

    public static void main(String[] args) {

        int[] nums = {5,4,-1,7,8};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
        System.out.println(new MaximumSubArray().maxSubArray2(nums));

    }
    public int maxSubArray(int[] nums) {

        int pre = 0, maxAns = nums[0];
        /**
         * f(i)=max{f(i−1)+nums[i],nums[i]}
         */
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray2(int[] nums) {

        int len = nums.length;
        int max = 0;
        //标准dp写法
        /**
         * f(i)=max{f(i−1)+nums[i],nums[i]}
         */
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
