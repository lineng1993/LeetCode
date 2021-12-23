package array.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * @author lin  2021/12/22 20:10
 */
public class Subsets {

    public static void main(String[] args) {


        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, nums.length, path, res);
        return res;

    }

    private void backtrack(int[] nums, int begin, int len, List<Integer> path, List<List<Integer>> res){

        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, len, path, res);
            path.remove(path.size() - 1);
        }
    }
}
