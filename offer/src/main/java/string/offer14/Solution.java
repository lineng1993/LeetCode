package string.offer14;

/**
 * 题目：输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？
 * 如果字符串s2中包含字符串s1的某个变位词，则字符串s1至少有一个变位词是字符串s2的子字符串。
 * 假设两个字符串中只包含英文小写字母。例如，字符串s1为"ac"，字符串s2为"dgcaf"，由于字符串s2中包含字符串s1的变位词"ca"，因此输出为true。
 * 如果字符串s1为"ab"，字符串s2为"dgcaf"，则输出为false。
 * @author lin  2022/5/23 11:14
 */
public class Solution {


    public boolean checkInclusion(String s1, String s2){
        if (s2.length() < s1.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)){
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(count)){
                return true;
            }
        }
        return false;

    }

    private boolean allZero(int[] count){
        for (int i : count) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }

}
