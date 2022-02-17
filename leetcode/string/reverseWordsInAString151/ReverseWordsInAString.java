package string.reverseWordsInAString151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Medium
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 *
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * @author lin  2022/2/17 19:14
 */
public class ReverseWordsInAString {


    /**
     * 掉包侠解法
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> res = Arrays.asList(s.split("\\s+"));
        Collections.reverse(res);
        return String.join(" ", res);
    }

    /**
     * 自己实现系统函数
     */
    public String reverseWords2(String s) {
        StringBuilder sb = trim(s);
        reverse(sb, 0, sb.length() - 1);
        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    private StringBuilder trim(String s){
        int left = 0, right = s.length() - 1;
        //去掉头尾空格
        while (left <= right && s.charAt(left) == ' '){
            left++;
        }
        while(left <= right && s.charAt(right) == ' '){
            right--;
        }
        //去掉中间空格
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }


    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }
}
