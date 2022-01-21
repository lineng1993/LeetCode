package array.minimumSizeSubarraySum209;

/**
 * Medium
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *

 * @author lin  2022/1/21 下午3:52
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen2(7, nums));

        int[] nums1 = {1,4,4};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen2(4, nums1));

        int[] nums2 = {1,1,1,1,1,1,1,1,1};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen2(11, nums2));

    }

    public int minSubArrayLen(int target, int[] nums) {

        /**
         * 暴力解法 双重for
         */
        int subLength = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) return 1;

            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if (sum >= target){
                    subLength = j - i + 1;
                    res = Math.min(res, subLength);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 滑动窗口：
     */

    public int minSubArrayLen2(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length; k++) {
            sum += nums[k];
            while (sum >= target){
                res = Math.min(res, k - left + 1);
                sum -= nums[left++];  //这里比较巧妙，移动左指针同时减去sum
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
