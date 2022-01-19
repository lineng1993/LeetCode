package greedy.jumpGame55;

/**
 * Medium
 * @author lin  2022/1/19 19:52
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {100,2,1,0,4};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了 0，卡住跳不动了
            if (farthest <= i) {
                return false;
            }
            if (farthest > n - 1){
                return true;
            }
        }
        return false;
    }
}
