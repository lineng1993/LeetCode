package number;

/**
 * 剑指offerII  001
 *
 * @author lin  2022/2/10 下午7:11
 */
public class DivideTwoIntegers {


    public static void main(String[] args) {

        System.out.println(new DivideTwoIntegers().divide(15, 15));
    }



    public int divide(int dividend, int divisor) {
        //int型整数的除法只有一种情况会导致溢出，即（-231次方）/（-1）。这是因为最大的正数为231-1，231超出了正数的范围
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //负数转为正数时可能溢出，但正数转为负数不会，先都转为负数
        int negative = 2;
        if (dividend > 0){
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0){
            negative--;
            divisor = -divisor;
        }
        int res = divideCore(dividend, divisor);
        // == 1说明有一个负数，取负值
        return negative == 1 ? -res:res;

    }

    private int divideCore(int dividend, int divisor){
        int res = 0;

        while (dividend <= divisor){

            int value = divisor;
            int quot = 1;
            while ((value >= (Integer.MIN_VALUE >> 1)) && dividend < value + value){
                quot += quot;
                value += value;
            }
            res += quot;
            dividend -= value;
        }
        return res;
    }

}
