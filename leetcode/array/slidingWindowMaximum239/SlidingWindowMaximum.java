package array.slidingWindowMaximum239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Hard
 * @author lin  2022/4/14 08:23
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow2(nums, 3)));

    }
    //执行超时了
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int resSize = n - k + 1;
        int[] res = new int[resSize];
        for (int i = 0; i < resSize; i++) {
            int j =  i;
            //构建大顶堆
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            while (j < i + k){
                queue.add(nums[j]);
                j++;
            }
            res[i] = queue.poll();
        }
        return res;
    }



    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int resSize = n - k + 1;

        //Deque 只保留最大值
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[resSize];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;

    }


}