package string.palindromePartitioning131;

import java.util.*;

/**
 * Medium
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * @author lin  2021/12/23 17:38
 */
public class PalindromePartitioning {

    private int[][] f;

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

    public List<List<String>> partition(String s) {

        /**
         * 思路：获取所有可能的分法，在判断是否是回文（回溯？）
         */
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        f = new int[len][len];
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }


    private boolean checkPalindrome(char[] charArray, int left, int right) {
        if (f[left][right] == 1){
            return true;
        }else if (f[left][right] == -1){
            return false;
        }
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                f[left][right] = -1;
                return false;
            }
            f[left][right] = 1;
            left++;
            right--;
        }
        return true;
    }

}
