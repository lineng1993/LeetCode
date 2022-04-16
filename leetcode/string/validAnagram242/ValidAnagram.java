package string.validAnagram242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * @author lin  2022/4/16 09:39
 */
public class ValidAnagram {


    public boolean isAnagram1(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram2(String s, String t){
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            Integer count = sMap.get(c);
            if (count == null) return false;
            else if (count > 1) sMap.put(c, count - 1);
            else sMap.remove(c); // 数量相等了移除掉，如果后续还出现了会返回null，说明不相等了已经，直接返回false
        }
        return sMap.isEmpty(); //这里比较巧妙，遇到一个移除一个
    }

    public boolean isAnagram3(String s, String t){
        //因为题目只会出现小写字母，所以一个26位数组即可，比较每一位的数量
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }

}
