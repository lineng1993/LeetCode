package array.findPeakElement162;

/**
 * Medium
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement {

    public static void main(String[] args) {

        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        /**
         * 有时间复杂度的要求意味这必须二分法
         */
        int n = nums.length;
        int left = 0, right = n - 1, res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0){
                return mid;
            }
            if (compare(nums, mid, mid + 1) < 0){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        return -1;

    }

    private int compare(int[] nums, int index1, int index2){
        int[] num1 = get(nums, index1);
        int[] num2 = get(nums, index2);
        if (num1[0] != num2[0]){
            return num1[0] > num2[0] ? 1:-1;
        }
        if (num1[1] == num2[1]){
            return 0;
        }
        return num1[1] > num2[1] ? 1:-1;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

}
