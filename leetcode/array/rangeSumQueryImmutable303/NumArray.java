package array.rangeSumQueryImmutable303;

/**
 * Easy
 * 前缀和数组
 * @author lin  2022/4/20 16:15
 */
public class NumArray {


    public static void main(String[] args) {


        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(1,6));
    }

    private final int[] preNums;

    public NumArray(int[] nums) {

        preNums = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }

}
