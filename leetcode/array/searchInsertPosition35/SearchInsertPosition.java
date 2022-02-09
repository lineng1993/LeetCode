package array.searchInsertPosition35;

/**
 * Easy
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。

 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right){

            int mid = left + (right - left) / 2; //防止溢出
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        //在最左（最左时right = -1）或者最右
        return right + 1;

    }
}
