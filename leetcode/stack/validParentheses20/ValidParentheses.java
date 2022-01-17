package stack.validParentheses20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Easy
 * @author lin  2022/1/17 15:02
 */
public class ValidParentheses {

    private Map<Character, Character> pairs = new HashMap<Character, Character>(){{
        put('{', '}');
        put('(', ')');
        put('[', ']');

    }};
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    /**
     * 比字典更好的一种方式
     */

    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

}
