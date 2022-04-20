package array.offer10;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * 需要结合前缀和数组去理解：array:303  https://labuladong.github.io/algo/2/18/21/
 * 输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组？例如，输入数组[1，1，1]，k的值为2，有2个连续子数组之和等于2
 * @author lin  2022/4/20 11:59
 */
public class SubArraySum {


    public static void main(String[] args) {

        System.out.println(new SubArraySum().subarraySum(new int[]{1,1,1,1}, 2));
    }


    public int subarraySum(int[] nums, int k){
        // 哈希表的键是前i个数字之和，值为每个和出现的次数
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            //找到前缀和为 sum-k index 的，因为index 到当前index的子数组和就是K
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
