package array.trappingRainWater42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Hard
 * 单调栈解法，查看84题的思路
 * @author lin  2022/3/7 19:40
 */
public class TrappingRainWater {


    public int trap(int[] height){

        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int width = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += width * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}
