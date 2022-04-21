package dp.targetSum494;

/**
 * Medium
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * @author lin  2022/4/21 19:40
 */
public class TargetSum {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        System.out.println(new TargetSum().findTargetSumWays(nums, 3));
    }


    public int findTargetSumWays(int[] nums, int target) {
        return process1(nums, 0, target);
    }

    /**
     * 使用arr[index..]区间内的数字
     * 任意加减使得结果等于rest;
     */
    private int process1(int[] arr, int index, int rest){
        if (index == arr.length){ //base case ：全部遍历完成 如果rest = 0,说明找到一种方法，否则找不到
            return rest == 0 ? 1 : 0;
        }
        //当前位置选择+号，当前位置的理解很重要,那么后续位置rest应该减去当前值，反之同理       //当前位置选择减号
        return process1(arr, index + 1, rest - arr[index])  + process1(arr, index + 1, rest + arr[index]);
    }




}
