package stack.nextGreaterElement496;

import java.util.*;

/**
 * Easy
 * @author lin  2022/4/11 20:02
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement2(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //暴力解法
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < nums1.length; i++) {
           int j = 0;
           //先找到对应元素
           while (j < n && nums2[j] != nums1[i]){
               j++;
           }
           // 从下个元素找到比当前元素大的
           int k = j + 1;
           while (k < n && nums2[k] < nums2[j]){
               k++;
           }
           res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        /*
         * 单调栈+哈希表
         */
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
