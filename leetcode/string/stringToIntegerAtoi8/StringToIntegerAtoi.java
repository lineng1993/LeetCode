package string.stringToIntegerAtoi8;

/**
 * Medium
 * @author lin  2022/3/3 14:48
 */
public class StringToIntegerAtoi {


    public static void main(String[] args) {


    }

    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) return 0;
        char[] chars = s.toCharArray();

        int left = 0;
        while (left < len && chars[left] == ' '){
            left++;
        }
        if (left == len) {
            return 0;
        }

        int sign = 1; //标识正负，可以直接乘法
        char firstChar = chars[left];
        if (firstChar == '+') {
            left++;
        } else if (firstChar == '-') {
            left++;
            sign = -1;
        }
        int res = 0;
        while (left < len){
            char currChar = chars[left];
            if (currChar > '9' || currChar < '0') {
                break;
            }
            //避免溢出
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (currChar - '0');
            left++;
        }
        return res;
    }
}
