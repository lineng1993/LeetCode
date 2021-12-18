package string.multiplyStrings43;

/**
 * Medium
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("120", "12"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        String ans = "0";
        int m = num1.length(), n = num2.length();
        //string num2 分别乘
        for (int i = n - 1; i >= 0; i--){
            StringBuilder curr = new StringBuilder();
            int add = 0;

            for (int j = n-1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0){
                curr.append(add % 10);
            }
            ans = addString(ans, curr.reverse().toString());
        }
        return ans;
    }

    private String addString(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >= 0 || j >=0 || add != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            res.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }

}
