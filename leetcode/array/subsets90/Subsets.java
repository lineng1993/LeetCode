package array.subsets90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * @author lin  2022/1/11 20:14
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, nums.length, path, res);
        return res;
    }

    private void backtrack(int[] nums, int begin, int len, List<Integer> path, List<List<Integer>> res){

        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            if (i > begin && nums[i] == nums[i - 1]) break;
            path.add(nums[i]);
            backtrack(nums, i + 1, len, path, res);
            path.remove(path.size() - 1);
        }
    }
}
