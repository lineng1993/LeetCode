package array.medianOfTwoSortedArrays4;

import java.util.Arrays;

/**
 * Hard
 * @author lin  2021/12/9 16:23
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //一开始思路：不考虑时间复杂度，对两个数组重新排序，取中位数
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length + 1, nums2.length);
        Arrays.sort(array);
        if ((array.length & 1) == 0){
            return (array[array.length  / 2 - 1] + array[array.length  / 2]) / 2.0;
        }
        return array[array.length / 2];
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        //两个数组已经有序，可以归并，不用直接合并后sort
        //这种方式比方法一好一点，但是本质上还是m+n复杂度
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {

        // 题目要求log(m+n),需要使用2分法才能达到要求
        /**
         * 问题：如何二分？
         * 中位数本质是第K小的数字的一种，解法2中一次排除一个数字，因为数组是有序的，所以可以一次排除一批
         */
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
