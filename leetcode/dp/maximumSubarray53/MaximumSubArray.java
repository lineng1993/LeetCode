package dp.maximumSubarray53;


/**
 * Easy
 */
public class MaximumSubArray {

    public static void main(String[] args) {

        int[] nums = {5,4,-1,7,8};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

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

}
