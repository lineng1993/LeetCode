package array.offer09;

/**
 * @author lin  2022/5/26 11:17
 */
public class MinProductArray {

    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 6};
        MinProductArray minProductArray = new MinProductArray();
        System.out.println(minProductArray.numSubarrayProductLessThanK(nums, 100));

    }



    public int numSubarrayProductLessThanK(int[] nums, int k){

        long product = 1;
        int res = 0, left = 0;
        int n = nums.length;
        for (int right = 0; right < nums.length; right++) {

            product *= nums[right];
            while (left <= right && product >= k){
                product /= nums[left];
                left ++;
            }
            //这里双指针之间有多少数字，就有多少个数字积小于K的子数组
            res += right >= left ? right - left + 1 : 0;
        }
        return res;
    }
}
