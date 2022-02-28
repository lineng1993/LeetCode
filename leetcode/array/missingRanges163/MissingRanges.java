package array.missingRanges163;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin  2022/2/28 19:28
 * Easy
 */
public class MissingRanges {


    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(new MissingRanges().findMissingRanges2(nums, -1, 99));

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        /**
         * 复杂的错误思路，保留吧先，一开始的 pre 的思路其实是对的，自己后面又放弃了
         */
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (nums.length <= 1 || nums[0] >= upper || nums[n - 1] <= lower) return res;
        if (nums[0] > lower){
           int diff = nums[0] - lower;
           if (diff == 2){
               res.add(String.valueOf(lower + 1));
           }else {
               res.add(lower + "->" + (nums[0] -1));
           }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > upper) break;
            if (nums[i] - nums[i - 1] <= 1) continue;
            if (nums[i] - nums[i - 1] == 2){
                res.add(String.valueOf(nums[i - 1] + 1));
            }else {
                res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper){
            res.add((nums[n - 1] + 1) + "->" + (upper));
        }
        return res;
    }



    public List<String> findMissingRanges2(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        long pre = lower, u = upper;
        for (int num : nums) {
            if (num - pre == 1)
                res.add(String.valueOf(pre));
            else if (num - pre > 1)
                res.add(pre + "->" + (num - 1));
            pre = (long) num + 1; // 这步一定需要强制转换,因为num[i]和1都是int型,计算结果也为int型再赋给l,需提前进行类型转换
        }
        if (pre == u) res.add(String.valueOf(pre)); //处理数组最后到upper，也顺便处理了空数组或者
        else if (pre < u) res.add(pre + "->" + u);
        return res;
    }

}
