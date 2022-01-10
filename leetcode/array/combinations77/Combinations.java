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
            backtrack(res, path, i + 1 , n, k);
            path.remove(path.size() - 1);
        }
    }

}
