package array.removeDuplicatesFromSortedArray26;

/**
 * Easy
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author lin  2021/12/24 17:34
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        /**
         * 简单题，但是没什么思路，难点在于原地替换
         * 题解思路：双指针
         */

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;  //为什么从1开始，开始的难点在于从0开始然后比较后续，很难判断，也很难做替换，这里去替换前一个就迎刃而解
        while (fast < n){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 0, slow = 0;  //labuladong 博客的解法，理解了双指针从0肯定也是可以的，从1开始反而不好理解了
        while (fast < n){
            if (nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
