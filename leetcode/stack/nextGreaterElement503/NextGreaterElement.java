package stack.nextGreaterElement503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Medium
 * @author lin  2022/4/11 20:37
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElements(nums)));

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        //单调栈中保存的是下标
        Deque<Integer> stack = new LinkedList<>();
        //把数组翻倍，这样能循环在遍历一次最后一个节点，取模是当i超出n后又从0开始在遍历一次
        for (int i = 0; i <2 * n - 1; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

}
