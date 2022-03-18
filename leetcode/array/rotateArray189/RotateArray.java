package array.rotateArray189;

import java.util.Arrays;

/**
 * @author lin  2022/3/18 11:32
 */
public class RotateArray {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 7);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int mov = k % n;
        if (mov == 0) return;

        int[] last = new int[k];

        for (int i = 0; i < mov; i++) {
            last[i] = nums[n - mov + i];
        }
        //拷贝回原数组
        for (int i = 0; i < n - mov; i++) {
            nums[n - 1 - i] = nums[n - 1 - mov - i];
        }
        for (int i = 0; i < mov; i++) {
            nums[i] = last[i];
        }
    }

}
