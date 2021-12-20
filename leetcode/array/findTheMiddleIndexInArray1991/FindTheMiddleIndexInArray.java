package array.findTheMiddleIndexInArray1991;

/**
 * Easy
 * @author lin  2021/12/20 20:02
 */
public class FindTheMiddleIndexInArray {

    public static void main(String[] args) {
        int[] nums = {2,3,-1,8,4};
        System.out.println(new FindTheMiddleIndexInArray().findMiddleIndex(nums));
    }

    public int findMiddleIndex(int[] nums) {

        int len = nums.length;
        for (int i = 1; i < len; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < len; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum){
                return i;
            }

        }
        return -1;

    }

}
