package string.longestCommonPrefix14;

/**
 * Easy
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strings = {
                "flower","flow","flight"
        };
        String[] strings2 = {
                "dog","racecar","car"
        };
        String[] strings3 = {
                "ab","a"
        };

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings2));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings3));

    }


    public String longestCommonPrefix(String[] strs) {

        /**
         * 一开始思路：这是简单题？暴力算法可能算是，先暴力求解
         * 暴力匹配每一位字符
         */
        StringBuilder res = new StringBuilder("");
        int index = 0;
        boolean flag = true;
        String first = strs[0];
        while (flag){
            if (index >= first.length()){
                break;
            }
            char c = first.charAt(index);
            boolean equal = true;
            for (int i = 1; i < strs.length; i++) {
                String cur = strs[i];
                if (index >= cur.length() || c != cur.charAt(index)){
                    flag = false;
                    equal = false;
                    break;
                }
            }
            if (equal){
                res.append(c);
                index++;
            }
        }
        return res.toString();

    }

}
