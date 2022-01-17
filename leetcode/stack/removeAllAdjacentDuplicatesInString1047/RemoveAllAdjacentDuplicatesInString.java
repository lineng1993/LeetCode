package stack.removeAllAdjacentDuplicatesInString1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Easy
 * @author lin  2022/1/17 15:15
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {

            if (stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();

    }
}
