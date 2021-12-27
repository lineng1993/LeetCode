package string.firstUniqueCharacterInAString387;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * @author lin  2021/12/27 18:41
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        /**
         * 和出现次数有关的，不要犹豫，hash
         * 老想着一次遍历，本题没想到需要记录2次
         */
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }
    /**
     * 优化解法
     */
    public int firstUniqChar2(String s) {

        /**
         * 和出现次数有关的，不要犹豫，hash
         * 老想着一次遍历，本题没想到需要记录2次
         */
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char c: chars){
            arr[c - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }


}
