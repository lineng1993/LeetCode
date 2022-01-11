package array.combinations77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 * @author lin  2022/1/10 19:00
 */
public class Combinations {


    public static void main(String[] args) {

        System.out.println(new Combinations().combine(4,2));
    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        //典型的回溯问题
        backtrack(res, new LinkedList<>(), 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int begin, int n, int k){

        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            //这里经常写错，这里是写i + 1, 老是写错成 begin + 1
            backtrack(res, path, i + 1 , n, k);
            path.remove(path.size() - 1);
        }
    }

    /**
     *  剪枝优化，n = 4, k = 4时 从 2 开始的遍历已经没有必要了，即剩余数量要大于K才可以
     *
     */
    private void backtrack2(List<List<Integer>> res, List<Integer> path, int begin, int n, int k){

        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            //这里经常写错，这里是写i + 1, 老是写错成 begin + 1
            backtrack2(res, path, i + 1 , n, k);
            path.remove(path.size() - 1);
        }
    }


}
