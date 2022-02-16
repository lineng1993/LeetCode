package array.plusOne66;

/**
 * Easy
 * @author lin  2022/2/16 17:36
 */
public class PlusOne {


    public int[] plusOne(int[] digits) {

        /**
         * 判断是否进位： num % 10 = 0;如果不进位可以直接返回，进位分两种
         * 1. 499->500
         * 2. 999->1000
         * 为了代码方便，反向遍历
         */
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int num = digits[i]++;
            if (num % 10 != 0) { //无进位，赋值后可以直接返回
                digits[i] = num;
                return digits;
            }
        }
        //处理999->1000
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}
