package array.majorityElement169;

import java.util.HashMap;
import java.util.Map;

/**
 * Easy
 * @author lin  2022/1/19 17:45
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));

        int[] nums1 = {3,2,3};
        System.out.println(new MajorityElement().majorityElement2(nums1));
    }


    public int majorityElement(int[] nums) {
        //常规思路：保存count,同时计算最大值
        Map<Integer, Integer /*<num:numCount>*/> counterMap = new HashMap<>();
        int max = 0;
        int res = -1;
        for (int num : nums){
            int count = counterMap.getOrDefault(num, 0);
            ++count;
            counterMap.put(num, count);
            if (count > max){
                max = count;
                res = num;
            }
        }
        return res;
    }

    /**
     * 投票法
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     */
    public int majorityElement2(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

}
