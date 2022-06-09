package array.kthLargestElementInAnArray215;

/**
 * @author lin  2022/6/8 20:16
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {


        int[] nums = {3,2,1,5,6,4};
        System.out.println(new KthLargestElementInAnArray().findKthLargest2(nums, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        //先排序，直接找，排序可以用快排
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {

        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = nums[i];
        }
        buildMinHeap(top);
        for (int i = k; i < nums.length; i++) {
            int tmp = top[0];
            if (tmp < nums[i]){
                setTop(top, nums[i]);
            }
        }
        return top[0];
    }


    private void quickSort(int[] nums, int l ,int r){

        if (l >= r) return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    private int partition(int[] nums, int l ,int r){

        int i = l ,j = r;
        while(i < j){
            //两个while不能交互顺序，因为此时的 i 位置是大于 num[l] 的，返回就报错了
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void buildMinHeap(int[] nums){

        int last = nums.length - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }

    // 大顶堆
    private void heapify(int[] nums, int index, int length){

        int left = (index << 1) + 1;
        int right = left + 1;

        int min = index;

        if(left < length && nums[left] < nums[min]){
            min = left;
        }
        if(right < length && nums[right] < nums[min]){
            min = right;
        }
        if (min != index){
            swap(nums, min, index);
            heapify(nums, min, length);
        }
    }

    // 将堆顶元素进行更换，继续进行沉降
    private void setTop(int[] nums, int top) {
        nums[0] = top;
        heapify(nums, 0, nums.length);
    }



}
