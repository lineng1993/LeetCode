package tree.uniqueBinarySearchTrees96;

/**
 * @author lin  2021/12/3 15:23
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n){
        return count(1, n);
    }

    int count(int lo, int hi){
        if (lo > hi) return 1;
        int res = 0;
        for (int i = lo; i <= hi ; i++) {
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            res += left * right;
        }
        return res;
    }
}
