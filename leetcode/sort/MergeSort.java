package sort;

/**
 * @author lin  2021/12/9 09:54
 */
public class MergeSort {


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
}
