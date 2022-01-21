package array.squaresOfASortedArray977;

import java.util.Arrays;

/**
 * Easy
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @author lin  2022/1/21 下午3:35
 */
public class SquaresOfASortedArray {


    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(nums)));

    }


    public int[] sortedSquares(int[] nums) {

        //简单暴力的话直接平方然后排序，这里使用双指针法: 数组有序的情况下最大值只会出现在最左或者最右
        int len = nums.length;
        int i = 0, j = len - 1, k = j;

        int[] res = new int[nums.length];
        while (i <= j){
            int x = nums[i] * nums[i];
            int y = nums[j] * nums[j];
            if (x > y){
                res[k--] = x;
                i++;
            }else {
                res[k--] = y;
                j--;
            }
        }
        return res;
    }

}
