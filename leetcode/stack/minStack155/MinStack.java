package stack.minStack155;

import java.util.LinkedList;

/**
 * Easy
 */
public class MinStack {


    public static void main(String[] args) {

        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());

    }


    private final LinkedList<Integer> min;
    private final LinkedList<Integer> stack;

    public MinStack() {

        min   = new LinkedList<>();
        stack = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {

        stack.push(val);
        min.push(Math.min(val, min.peek()));  //每次都push,后边也就可以每次都pop了

    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.getFirst();

    }

    public int getMin() {

        return min.getFirst();
    }

}
