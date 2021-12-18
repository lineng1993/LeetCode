package string.reverseString344;

/**
 * Easy
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ReverseString {


    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        new ReverseString().reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        /**
         * 一开始思路：双指针，不断更换 i, j 的字符串
         */
        int i = 0, j = s.length - 1;
        while (i < j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

    public void reverseString2(char[] s) {
        int n = s.length;
        /**
         * 更好的写法
         */
        for(int l = 0, r = n - 1; l < n; l++, r--){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
        }
    }

}
