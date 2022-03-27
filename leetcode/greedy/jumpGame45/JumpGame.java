package greedy.jumpGame45;


/**
 * Medium
 * 相比55题，多了一个要求：使用最少次数
 */
public class JumpGame {

    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,2,3};
        System.out.println(new JumpGame().jump(nums));
    }


    public int jump(int[] nums) {

        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { // 遇到跳跃得最大距离了，需要在跳一次
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
