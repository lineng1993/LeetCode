package tree.uniqueBinarySearchTrees96;

/**
 * Medium
 * @author lin  2021/12/3 15:23
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n){

        /**
         * https://mp.weixin.qq.com/s/kcwz2lyRxxOsC3n11qdVSw
         * F(i,n)=G(i−1)⋅G(n−i)
         */
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
