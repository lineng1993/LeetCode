package string.decodeString394;

import java.util.LinkedList;

/**
 * Medium
 * 本题比较容易想到用栈，难点在括号嵌套
 * @author lin  2022/3/29 11:27
 */
public class DecodeString {

    public static void main(String[] args) {

//        String s1 = "2[2[2[a]]]";
        String s2 = "3[a]2[bc]";
        String s3 = "3[a2[c]]";

        DecodeString decodeString = new DecodeString();
//        System.out.println(decodeString.decodeString(s1));
        System.out.println(decodeString.decodeString(s2));
        System.out.println(decodeString.decodeString(s3));

    }

    public String decodeString(String s) {

        LinkedList<String> stkRes = new LinkedList<>();
        LinkedList<Integer> multiStk = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for (char c: s.toCharArray()){

            if (c == '['){
                multiStk.push(multi); //保存倍数，如果有的话，0也算
                stkRes.push(res.toString());
                res = new StringBuilder();//保存了到栈了，下次遇到字符直接拼接保存

            }else if (c == ']'){ //触发计算
                int curMulti = multiStk.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stkRes.pop() + tmp);
            }else if (c >= '0' && c <= '9'){
                multi = Integer.parseInt(c + "");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
