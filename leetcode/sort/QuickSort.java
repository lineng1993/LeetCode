package sort;

import java.util.Arrays;

/**
 * @author lin  2021/12/9 09:03
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] nums = {6,2,1,4,7,9,3,10,5,8};
//        new QuickSort().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 荷兰国旗问题, 数组分成三块,左侧 < target,中间 == target, 右侧 > target
     *  int[] nums = {-2,2,3,4,2,1};
     */

    private void rePartition(int[] nums, int target){

        int n = nums.length;
        int i = 0, l = 0, r = n - 1;
        while (i <= r){
            if (nums[i] < target){
                swap(nums, i, l);
                l++;
                i++;
            }else if (nums[i] == target){
                i++;
            }else {
                swap(nums, i, r);
                r--;
            }
        }
    }
}
