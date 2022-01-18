package greedy.assignCookies455;

import java.util.Arrays;

/**
 * Easy
 * @author lin  2022/1/18 19:54
 */
public class AssignCookies {


    public int findContentChildren(int[] g, int[] s) {

        /**
         * 核心思想是用尽量小的饼干满足尽量小的需求才能保证最多孩子满足，所以先排序
         *
         * 为了了满足更多的小孩，就不要造成饼干尺寸的浪费。
         * 大尺寸的饼干既可以满足胃口大的孩子也可以满足胃口小的孩子，那么就应该优先满足胃口大的。
         * 这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩。一开始的想法是错的，要从大开始喂饱，因为每个孩子最多只能给一块饼干
         */
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int j = 0;
        //从后遍历饼干：
        for (int i = s.length - 1; i >= 0; i--) {

            if (j >= 0 && s[j] >= g[i]){
                res++;
                j--;
            }
        }
        return res;
    }
}
