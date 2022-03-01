package dp.wordBreak139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Medium
 * @author lin  2022/3/1 20:04
 */
public class WordBreak {

    public static void main(String[] args) {

        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dp[i]= dp[j] && check(s[j..i−1])
         */
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
