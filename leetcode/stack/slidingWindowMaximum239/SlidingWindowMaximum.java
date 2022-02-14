package stack.slidingWindowMaximum239;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Hard
 * @author lin  2022/2/14 17:42
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, 3)));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length -k + 1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中index还在窗口内
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}