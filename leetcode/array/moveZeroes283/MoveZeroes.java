package array.moveZeroes283;

/**
 * @author lin  2022/5/26 11:43
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;

            }
        }
    }
}
