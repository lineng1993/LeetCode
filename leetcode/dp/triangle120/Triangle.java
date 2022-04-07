package dp.triangle120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Medium
 * @author lin  2022/4/7 19:12
 */
public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3,4));
        System.out.println(new Triangle().minimumTotal2(triangle));
    }



    public int minimumTotal(List<List<Integer>> triangle) {

        //想法太简单了，每层最小不代表全局最小，错误的测例：[[-1],[2,3],[1,-1,-3]]
        int sum = triangle.get(0).get(0);
        int len = triangle.size();
        int smallIndex = 0;
        for (int i = 1; i < len; i++) {

            List<Integer> list = triangle.get(i);

            int left = list.get(smallIndex);
            int right  = list.get(smallIndex + 1);

            smallIndex = left < right ? smallIndex : smallIndex + 1;

            sum += list.get(smallIndex);
        }
        return sum;
    }
    public int minimumTotal2(List<List<Integer>> triangle) {

        //理解了上述方法的错误之后，仔细思考其实这题还真是dp题，因为必须知道每一个完整的路径和才能判断出最小的
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {

                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

}
