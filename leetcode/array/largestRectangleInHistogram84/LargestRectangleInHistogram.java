package array.largestRectangleInHistogram84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Hard
 * 题解：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * @author lin  2022/3/7 19:50
 */
public class LargestRectangleInHistogram {


    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,1};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));

    }

    public int largestRectangleArea(int[] heights) {
        //边界条件
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {

            while(!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int curH = heights[stack.pollLast()]; //最大高度已经确定，可以计算前一个矩形的面积了

                while (!stack.isEmpty() && heights[stack.peekLast()] == curH) {  // 可以一起计算
                    stack.pollLast();
                }

                int curW;
                if (stack.isEmpty()){
                    curW = i;
                }else {
                    curW = i - stack.peekLast() - 1;
                }

                res = Math.max(res, curH * curW);
            }
            stack.add(i);
        }
        //可能相等或者末尾的值比较大，弹不出来，在计算一次，可以优化：加一个哨兵节点，末尾+0，一定回弹出来了
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    /**
     * 优化上述的问题，加哨兵
     */
    public int largestRectangleArea2(int[] heights) {
        //边界条件
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new LinkedList<>();
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

}
