package stack.dailyTemperatures739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Medium
 * @author lin  2022/1/17 15:32
 */
public class DailyTemperatures {

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));

        int[] temperatures2 = {30,40,50,60};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures2(temperatures2)));

        int[] temperatures3 = {30,60,90};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures2(temperatures3)));
    }

    /**
     * 先来个暴力常规写法
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                ret[index] = i - index;
            }
            stack.push(i);
        }
        return ret;

    }
}


