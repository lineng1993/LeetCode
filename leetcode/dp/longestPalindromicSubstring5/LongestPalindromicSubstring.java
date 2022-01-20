package dp.longestPalindromicSubstring5;

/**
 * Medium
 * @author lin  2022/1/20 17:37
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babbabad"));
    }


    public String longestPalindromeDp(String s) {


        return s;

    }

    /**
     * 中心扩散
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            //字符扩散
            int len1 = expandAroundCenter(s, i, i);
            //中间扩散
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            //更新长度
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
