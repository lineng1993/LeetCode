package array.containerWithMostWater11;

/**
 * Medium
 * @author lin  2021/12/17 17:35
 */
public class ContainerWithMostWater {

    /**
     * 一开始思路：暴力解法，肯定不行
     */
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;

        /**
         * 题解思路：双指针
         */
        while (i < j){
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
