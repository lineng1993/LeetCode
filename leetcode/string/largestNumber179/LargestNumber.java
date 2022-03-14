package string.largestNumber179;

import java.util.Arrays;

/**
 * Medium
 */
public class LargestNumber {


    public static void main(String[] args) {

        int[] nums = {3,30,34,5,9};
        System.out.println(new LargestNumber().largestNumber(nums));

    }

    public String largestNumber(int[] nums) {

        /*
         * 要想组成最大的整数，一种直观的想法是把数值大的数放在高位。于是我们可以比较输入数组的每个元素的最高位，
         * 最高位相同的时候比较次高位，以此类推，完成排序，然后把它们拼接起来。这种排序方式对于输入数组 没有相同数字开头 的时候是有效的，
         * 例如 [45, 56, 81, 76, 123][45,56,81,76,123]。
         * 下面考虑输入数组 有相同数字开头 的情况，例如 [4,42][4,42] 和 [4,45][4,45]。
         * 对于 [4,42][4,42]，比较 442 > 424442>424，需要把 44 放在前面；
         * 对于 [4,45][4,45]，比较 445 < 454445<454，需要把 4545 放在前面。
         */
        int n = nums.length;
        if (n == 0) return "";
        String[] s = new String[n];
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < s.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        /*
         * 核心就在于排序
         */
        Arrays.sort(s, (a, b) ->{
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });

        for (int i = 0; i < n; i++) {
            res.append(s[i]);
        }
        return res.toString();
    }

}
