package array.majorityElement229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lin  2022/1/19 19:34
 */
public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (cnt.containsKey(nums[i])) {
                cnt.put(nums[i], cnt.get(nums[i]) + 1);
            } else {
                cnt.put(nums[i], 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : cnt.keySet()) {
            if (cnt.get(x) > nums.length / 3) {
                ans.add(x);
            }
        }
        return ans;
    }
}
