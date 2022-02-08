package hash.longestConsecutiveSequence128;

import java.util.HashSet;
import java.util.Set;

/**
 * Medium
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet){
            if (!numSet.contains(num - 1)){
                int current = num;
                int currentStreak = 1;
                while (numSet.contains(current + 1)){
                    current += 1;
                    currentStreak += 1;
                }
                longest = Math.max(currentStreak, longest);
            }
        }
        return longest;

    }

}
