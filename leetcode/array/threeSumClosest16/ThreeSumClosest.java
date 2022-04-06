package array.threeSumClosest16;

import java.util.Arrays;

/**
 * @author lin  2022/4/6 20:02
 */
public class ThreeSumClosest {


    public static void main(String[] args) {

        int[] nums = {-1,2,1,-4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums); // 排序
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int l = i + 1, r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum -target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target){
                    return sum;
                }else if (sum < target){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return closest;
    }

}
