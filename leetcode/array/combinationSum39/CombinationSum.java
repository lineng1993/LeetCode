package array.combinationSum39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Medium
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * @author lin  2021/12/22 16:29
 */
public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        /**
         * 一开始思路：本题应该是回溯算法，
         * 题解：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
         *
         */

        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, 0, len, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, int len, Deque<Integer> path, List<List<Integer>> res)
    {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //找到满足条件的path
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意,去重
        for (int i = begin; i < len; i++) {

            path.add(candidates[i]);

            dfs(candidates, target - candidates[i], i, len, path, res);

            path.removeLast();
        }


    }
}
