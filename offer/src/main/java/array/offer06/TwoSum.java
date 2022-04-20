package array.offer06;

import java.util.Arrays;

/**
 * 应该算Easy,典型双指针问题
 * 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次
 * @author lin  2022/4/19 19:35
 */
public class TwoSum {


    public static void main(String[] args) {

        int[] nums = {1,3,5,6,7,12};
        System.out.println(Arrays.toString(new TwoSum().twoSum1(nums, 11)));
    }

    public int[] twoSum(int[] nums, int target){

        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j){
            int sum = nums[i] + nums[j];
            if (sum < target){
                i++;
            }else if (sum > target){
                j--;
            }else {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    //代码优化
    public int[] twoSum1(int[] nums, int target){

        int n = nums.length;
        int i = 0, j = n - 1;
        //直接在while循环里边判断即可
        while (i < j && nums[i] + nums[j] != target){
            int sum = nums[i] + nums[j];
            if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        //这里是肯定这么返回的首先
        return new int[]{i, j};
    }


}
