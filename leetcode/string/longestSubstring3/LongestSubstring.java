package string.longestSubstring3;

import java.util.*;

/**
 * Medium
 * @author lin  2021/12/20 17:32
 */
public class LongestSubstring {
    public static void main(String[] args) {

        System.out.println(new LongestSubstring().lengthOfLongestSubstring2("abcaacbb"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("aaa"));
    }


    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {

        // abca -> loc[97] = 0, loc[98] = 1, loc[99] = 2, 更新loc[97] = 3
        int[] loc = new int[128]; // 只包含数字，字母，符号，可以数组优化，记录字符的index（最大位置）
        Arrays.fill(loc, -1);
        int n = s.length();
        int res = 0, start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, loc[index] + 1); // 跳出重复区间：ex 'abcaa', start遇到 第三个 a 的时候start需要跳到第三个a才算脱离空间
            res = Math.max(res, i - start + 1);
            loc[index] = i;
        }
        return res;
    }
    //方法2的hashmap版本
    public int lengthOfLongestSubstring3(String s) {

        // abca -> loc[97] = 0, loc[98] = 1, loc[99] = 2, 更新loc[97] = 3
        Map<Character, Integer> loc = new HashMap<>(256);
        int n = s.length();
        int res = 0, start = 0;
        for (int i = 0; i < n; i++) {

            char c = s.charAt(start);
            if (loc.containsKey(c)){
                start = Math.max(loc.get(c) + 1, start);
            }
            res = Math.max(res, i - start + 1);
            loc.put(s.charAt(i), i);
        }
        return res;
    }

}
