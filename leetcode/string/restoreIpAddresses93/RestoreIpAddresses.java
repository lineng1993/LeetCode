package string.restoreIpAddresses93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lin  2022/3/28 19:30
 */
public class RestoreIpAddresses {


    public static void main(String[] args) {

        System.out.println(new RestoreIpAddresses().restoreIpAddresses("101023"));
    }

    public List<String> restoreIpAddresses(String s) {

        int len = s.length();
        List<String> res = new ArrayList<>();
        //如果当前字符长度大于12或者小于4都不满足
        if(len > 12 || len <4){
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        //深度优先搜索
        dfs(s,len, 0, 4, path, res);
        return res;

    }
    public void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res){

        if (begin == len){
            if (residue == 0){
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) break;
            if (len - i > residue * 3){
                continue;
            }
            if (isIpSegment(s, begin, i)){
                String cur = s.substring(begin, i + 1);
                path.addLast(cur);
                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }

    }

    private boolean isIpSegment(String s, int left, int right){
        int len = right - left + 1;
        if (len > 1 && s.charAt(len) == '0'){
            return false;
        }
        int res = 0;
        while (left <= right){
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
