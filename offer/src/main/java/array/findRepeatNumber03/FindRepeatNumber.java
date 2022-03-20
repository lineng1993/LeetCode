package array.findRepeatNumber03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lin  2022/3/18 11:23
 */
public class FindRepeatNumber {

    public static void main(String[] args) {


        int[] nums = {1,2,3,1,2,3};
        System.out.println(new FindRepeatNumber().findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {


        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {

            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

}
