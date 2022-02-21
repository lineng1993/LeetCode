package array.searchA2dMatrix74;

/**
 * Medium
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        System.out.println(new SearchA2dMatrix().searchMatrix(matrix, 3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        //思路：每次直接比较最后一位，然后二分查找；
        int res = -1;
        for (int i = 0; i < m; i++) {
            if (target > matrix[i][n-1]){
                continue;
            }
            res = binarySearch(matrix[i], target);
            break;
        }
        return res != -1;
    }
    private int binarySearch(int[] nums, int target){

        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }
}
