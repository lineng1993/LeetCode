package other.sqrtx69;

/**
 * Easy
 */
public class Sqrtx {

    public int mySqrt(int x) {

        /*
         * 二分查找
         */
        int l = 0, r = x, ans = -1;

        while (l <= x){
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;

    }

}
