package array.letterCombinationsOfAPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * @author lin  2022/1/28 下午4:26
 */
public class LetterCombinationsOfAPhoneNumber {


    public static void main(String[] args) {

        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }

    Map<Character, String[]> numMap = new HashMap<Character, String[]>(){{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t","u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};



    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        backtrack(res, new StringBuilder(), digits, digits.length(), 0);

        return res;
    }

    private void backtrack(List<String> re, StringBuilder combination,String digits, int len, int depth){
        if (depth == len) {
            re.add(combination.toString());
            return;
        }
        char digit = digits.charAt(depth);
        String[] letters = numMap.get(digit);
        int lettersCount = letters.length;
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters[i]);
            backtrack(re, combination, digits, len, depth + 1);
            combination.deleteCharAt(depth);
        }
    }
}
