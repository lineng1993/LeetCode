package array.generateParentheses22;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * 回溯入门参考：39，46等
 * @author lin  2021/12/22 19:16
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
//        dfs("", n, n, res);
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;

    }


    private void dfs(String curStr, int left, int right, List<String> res)
    {
        if (left == 0 && right == 0){
            res.add(curStr);
        }
        if (left > right) return; //剪枝的情况
        if (left > 0){
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0){
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    /**
     * 回溯解法
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
