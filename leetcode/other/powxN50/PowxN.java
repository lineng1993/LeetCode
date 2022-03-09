package other.powxN50;

/**
 * Medium
 */
public class PowxN {

    public static void main(String[] args) {

        System.out.println(new PowxN().myPow1(2,  2));
    }


    public double myPow(double x, int n) {

        /**
         * 对半乘法
         */
        return n > 0 ? powHelper(x, n) : 1.0 / powHelper(x, -(long) n);

    }

    private double powHelper(double x, long n){

        if (n == 0) return 1;
        double y = powHelper(x, n / 2);
        return ((n & 1) == 0) ? y * y : y * y * x;
    }

    public double myPow1(double x, int n) {

        /**
         * 对半乘法,常规写法：
         */
        double res = 1.0;
        for (int i = n; i != 0; i = i/2) {
            if ( i % 2 != 0)
                res *= x;
            x *= x;
        }
        return n > 0 ? res : 1.0 / res;
    }
}
