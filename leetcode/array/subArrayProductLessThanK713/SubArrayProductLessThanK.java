package array.subArrayProductLessThanK713;

/**
 * Medium
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class SubArrayProductLessThanK {

    public static void main(String[] args) {

        System.out.println(new SubArrayProductLessThanK().numSubArrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }


    public int numSubArrayProductLessThanK(int[] nums, int k) {

        int multiply = 1, left = 0, res = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            multiply *= nums[i];
            while (multiply >= k){
                multiply /= nums[left++];
            }

            /*
             * right-left+1的切入点是思维要放在区间的右边往左边延伸，
             * 例如区间[1, 2, 3, 4]满足要求，固定住right(4)的点，可选区间右[4]、[4, 3]、[4, 3, 2]、[4, 3, 2, 1]即为数组的长度，也就是right-left+1。
             * 而right是递增的，此时[1, 2, 3]的区间已经处理完（[3]、[3, 2]、[3、2、1]）。
             * 如果从left为切入点，就会有[1, 2, 3, 4]和[1, 2, 3]都有[1]，不就是重复了的错乱思维。
             */
            res += (i - left + 1);
        }
        return res;

    }

}
