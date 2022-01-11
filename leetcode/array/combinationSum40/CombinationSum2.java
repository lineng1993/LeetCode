package array.combinationSum40;

import java.util.*;

/**
 * Medium
 * candidates 中的每个元素在每个组合中只能使用 一次
 * 注意：解集不能包含重复的组合。
 * @author lin  2022/1/11 19:49
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] nums1 = {10,1,2,7,6,1,5};
        System.out.println(new CombinationSum2().combinationSum(nums1, 8));

        int[] nums2 = {2,5,2,1,2};
        System.out.println(new CombinationSum2().combinationSum(nums2, 5));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 关键步骤
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param len        冗余变量
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            /**
             * 这个避免重复当思想是在是太重要了。
             * 这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
             *                   1
             *                  / \
             *                 2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
             *                /     \
             *               5       5
             *                 例2
             *                   1
             *                  /
             *                 2      这种情况确是允许的
             *                /
             *               2
             *
             * 为何会有这种神奇的效果呢？
             * 首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
             * 可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
             * 因为当第二个2出现的时候，他就和前一个2相同了。
             *
             * 那么如何保留例2呢？
             * 那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
             * 例2的两个2是处在不同层级上的。
             * 在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
             * 必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
             * 第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
             */

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }


}
