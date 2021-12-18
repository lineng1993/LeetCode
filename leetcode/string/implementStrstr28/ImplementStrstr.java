package string.implementStrstr28;

/**
 * Easy
 */
public class ImplementStrstr {

    public static void main(String[] args) {

        System.out.println(new ImplementStrstr().strStr("hello", "ll"));
        System.out.println(new ImplementStrstr().strStr("a", "a"));

    }


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int len = haystack.length();
        int nlen = needle.length();
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean flag = true;
                if (i + needle.length() <= len){
                    for (int j = 0; j < nlen; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        return i;
                    }
                }

            }
        }
        return -1;
    }
}
