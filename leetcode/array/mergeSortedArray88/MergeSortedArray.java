package array.mergeSortedArray88;

import java.util.Arrays;

/**
 * Easy
 * @author lin  2021/12/23 17:00
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
//        new MergeSortedArray().merge(num1, 3, num2, 3);
        new MergeSortedArray().merge2(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /**
         * 归并排序的归并阶段:使用双指针
         * 误区：简单题想用简单原地实现，题解其实也不是原地实现的
         */
        int[] sorted = new int[m + n];
        int i = 0, j = 0;
        int cur;
        while (i < m || j < n){
            if (i == m){
                cur = nums2[j++];
            }else if(j == n){
                cur = nums1[i++];
            }else if(nums1[i] < nums2[j]){
                cur = nums1[i++];
            }else{
                cur = nums2[j++];
            }
            sorted[i + j - 1] = cur;
        }
        for (int k = 0; k < sorted.length; k++) {
            nums1[k] = sorted[k];
        }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        /**
         * 上述代码使用了临时空间，主要为了避免num1被覆盖
         * 解决方式：选最大的往后放，反向遍历即可
         */
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0){
            if (p1 == -1){
                cur = nums2[p2--];
            }else if(p2 == -1){
                cur = nums1[p1--];
            }else if(nums1[p1] < nums2[p2]){
                cur = nums2[p2--];
            }else{
                cur = nums1[p1--];
            }
            nums1[tail--] = cur;
        }
    }
}
