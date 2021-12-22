package array.permutations46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 回溯类似题目：39，40，46，47，78，90
 * @author lin  2021/12/22 16:34
 */
public class Permutations {


    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(new Permutations().permute(nums));


    }

    // 使用一个动态数组保存所有可能的全排列
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        /**
         * 题解：
         * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
         */

        int len = nums.length;

        LinkedList<Integer> track = new LinkedList<>();
        if (len == 0) {
            return res;
        }
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track){
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            System.out.println("递归之前=>" + track);
            backtrack(nums, track);
            track.removeLast();
            System.out.println("递归之后=>" + track);
        }
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res)
    {
        if (depth == len){
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
}
