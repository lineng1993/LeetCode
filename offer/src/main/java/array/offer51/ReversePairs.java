package array.offer51;

/**
 * @author lin  2022/3/29 20:16
 */
public class ReversePairs {


    public static void main(String[] args) {

        int[] nums = {7,3,2,6,0,1,5,4};
        System.out.println(new ReversePairs().reversePairs1(nums));
    }

    public int reversePairs(int[] nums) {

        int sum = 0;
        //暴力解法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    sum++;
                }
            }
        }
        return sum;

    }

    int[] nums, tmp;
    public int reversePairs1(int[] nums) {

        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r){
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);

        //合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++){
            if (i == m + 1){
                nums[k] = tmp[j++];
            }else if (j == r + 1 || tmp[i] <= tmp[j]){
                nums[k] = tmp[i++];
            }else{
                nums[k] = tmp[j++];
                res += m - i + 1;
            }
        }
        return res;
    }
}
