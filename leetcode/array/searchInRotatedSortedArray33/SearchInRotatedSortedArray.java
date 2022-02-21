package array.searchInRotatedSortedArray33;

/**
 * Medium
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 */
public class SearchInRotatedSortedArray {


    public static void main(String[] args) {

        int[] nums = {6, 7, 0, 1, 2, 4, 5};
        int[] nums2 = { 4, 5, 6, 7, 0,  1, 2};
//        System.out.println(new SearchInRotatedSortedArray().search2(nums, 4));
        System.out.println(new SearchInRotatedSortedArray().search2(nums2, 5));
    }


    public int search(int[] nums, int target) {
        /*
         * 按照easy 题的思路，直接遍历
         */
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (target == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        /*
         * 比O(n) 快的话只能二分查找,二分法分2种情况：
         * 1：
         */

        int n = nums.length;
        //base
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        int l = 0, r = n - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            if (nums[0] < nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

}
