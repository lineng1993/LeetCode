package string.addStrings415;

/**
 * Easy
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        /**
         * 跟链表相加是一样的
         */
        int i = num1.length() - 1, j = num2.length() - 1, adder = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >=0 || adder != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + adder;
            res.append(sum % 10);
            adder = sum / 10;
            i--;
            j--;
        }
        /**
         * 需要反转字符串
         */
        res.reverse();
        return res.toString();
    }
}
