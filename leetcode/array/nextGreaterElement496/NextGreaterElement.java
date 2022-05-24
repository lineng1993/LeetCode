package array.nextGreaterElement496;

import java.util.*;

/**
 * Easy
 * 1. nums1 是 nums2 的子集
 * 2. 不含重复元素
 * @author lin  2022/5/23 20:43
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums = {2,1,2,4,3};
        System.out.println(Arrays.toString(new NextGreaterElement().singleArray(nums)));
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //计算出nums2的下一个最大元素，用map保存
        int[] greater = singleArray(nums2);
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            resMap.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = resMap.get(nums1[i]);
        }
        return res;
    }


    private int[] singleArray(int[] nums){

        int n = nums.length;
        int[] res = new int[n];

        Deque<Integer> queue = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!queue.isEmpty() && nums[i] >= queue.peek()){
                queue.pop();
            }
            res[i] = queue.isEmpty() ? -1 : queue.peek();
            queue.push(nums[i]);
        }
        return res;
    }

}
