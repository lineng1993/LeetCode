package array.permutations47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * @author lin  2022/1/27 下午7:32
 */
public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        System.out.println(new Permutations().permuteUnique(nums));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, used, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] num, List<List<Integer>> res, boolean[] used,  List<Integer>path){

        if (path.size() == num.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) continue;
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) continue;
            path.add(num[i]);
            System.out.println("递归之前=>" + path);
            used[i] = true;
            backtrack(num, res, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
            System.out.println("递归之后=>" + path);;
        }
    }
}
