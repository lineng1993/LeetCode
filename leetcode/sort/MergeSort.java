package sort;

/**
 * @author lin  2021/12/9 09:54
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] nums = {7,3,2,6,0,1,5,4};
        new MergeSort().sort(nums);
    }


    private int[] aux;
    private void sort(int[] nums){
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    void mergeSort(int[] nums, int l, int r){

        // 终止条件
        if (l >= r) return;
        // 递归划分
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid); //左数组
        mergeSort(nums, mid + 1, r); //右数组
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){  //拷贝数组
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid)                nums[k] = aux[j++];
            else if(j > hi)             nums[k] = aux[i++];
            else if(aux[j] < aux[i])    nums[k] = aux[j++];
            else                        nums[k] = aux[i++];
        }
    }


    void process(int[] nums, int l, int r){
        if (l == r) return;
        int mid = l + ((r- l) >> 1);
        process(nums, l, mid);
        process(nums, mid + 1, r);
        merge2(nums, l, mid, r);
    }

    void merge2(int[] nums, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r){
            help[i++] = nums[p1] < nums[p2] ? nums[p1++]:nums[p2++];
        }
        while (p1 <= mid){
            help[i++] = nums[p1++];
        }
        while (p2 <= r){
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l + i] = help[i];
        }
    }

}
