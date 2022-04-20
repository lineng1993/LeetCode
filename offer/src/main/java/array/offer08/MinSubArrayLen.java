package array.offer08;


/**
 * Medium
 * 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少？如果不存在所有数字之和大于或等于k的子数组，则返回0
 * @author lin  2022/4/19 19:48
 */
public class MinSubArrayLen {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new MinSubArrayLen().minSubArrayLen(19, nums));
        int[] nums1 = {5,1,4,3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, nums1));


    }

    public int minSubArrayLen(int k, int[] nums){
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        //不能排序，暴力解法就是循环
        for (int i = 0; i < n; i++) {
            int r = i + 1;
            int sum = nums[i];
            while (r < n){
                sum += nums[r];
                if (sum >= k){
                    res = Math.min(res, r - i + 1);
                }
                r++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
