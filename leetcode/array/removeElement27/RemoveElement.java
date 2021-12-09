package array.removeElement27;

/**
 * Easy
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * @author lin  2021/12/9 10:36
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        /**
         * 一开始思路：双指针
         * i 正常++
         * j 遇到不同值在++，同时进行赋值
         */
        int j = 0;
        int length = nums.length;
        for (int i = 0; i < length;i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j + 1;
    }
}
