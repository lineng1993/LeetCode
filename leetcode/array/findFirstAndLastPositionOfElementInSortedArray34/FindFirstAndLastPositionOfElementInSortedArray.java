package array.findFirstAndLastPositionOfElementInSortedArray34;

import java.util.Arrays;

/**
 * Medium
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange1(nums, 8)));
    }


    public int[] searchRange(int[] nums, int target) {

        //先不考虑复杂度，那么这个题应该是easy
        //base
        if (nums.length == 0) return new int[]{-1, -1};
        int i = -1, j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (target == nums[k]){
                i = j = k;
                while (j + 1 < nums.length && nums[j + 1] == target){
                    j++;
                }
                break;
            }
        }
        return new int[]{i, j};
    }
    //优化解法，思考：升序数组 要求为logn 的复杂度，那么只有二分法了

    /**
     * 计算出来的右边界是不包好target的右边界，左边界同理
     * 情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
     * 情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
     * 情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
     */
    public int[] searchRange1(int[] nums, int target) {

        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
}
