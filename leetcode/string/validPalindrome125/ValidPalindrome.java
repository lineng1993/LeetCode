package string.validPalindrome125;

/**
 * Easy
 * @author lin  2021/12/20 17:09
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));

    }

    public boolean isPalindrome(String s) {
        /**
         * 一开始思路：双指针
         */
        if (s == null || s.length() <= 1) return true;
        int l = 0, r = s.length() - 1;
        String lowerCase = s.toLowerCase();
        while (l < r){
            char left = lowerCase.charAt(l);
            char right = lowerCase.charAt(r);
            if (!isChar(left)){ //可以替换成Character.isLetterOrDigit
                l++;
                continue;
            }
            if (!isChar(right)){
                r--;
                continue;
            }
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isChar(char c){
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
