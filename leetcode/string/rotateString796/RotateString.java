package string.rotateString796;


/**
 * Easy
 */
public class RotateString {



    public boolean rotateString(String s, String goal) {


        /*
         * 由于 A + A 包含了所有可以通过旋转操作从 A 得到的字符串，因此我们只需要判断 B 是否为 A + A 的子串即可。
         */

        return s.length() == goal.length() && (s + s).contains(goal);


    }

}
