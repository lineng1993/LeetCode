package string.simplifyPath71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Medium
 * @author lin  2022/2/18 15:44
 *
 */
public class SimplifyPath {

    public static void main(String[] args) {

        String test1 = "/home/";
        String test2 = "/../";
        String test3 = "/home//foo/";
        String test4 = "/a/./b/../../c/";

        SimplifyPath simply = new SimplifyPath();
        System.out.println(simply.simplifyPath(test1));
        System.out.println(simply.simplifyPath(test2));
        System.out.println(simply.simplifyPath(test3));
        System.out.println(simply.simplifyPath(test4));

    }

    public String simplifyPath(String path){
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)){ //弹出到上一级目录，即弹出栈顶的元素
                if (!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(name.length() > 0 && !".".equals(name)){  //split后会存在空格，. 代表当前目录，不需要处理，都跳过即可
                stack.addLast(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()){
            sb.append("/");
        }else{
            while (!stack.isEmpty()){
                sb.append("/");
                sb.append(stack.pollFirst());
            }
        }
        return sb.toString();
    }


    public String simplifyPath1(String path) {

        //一开始思路：反向简化，先删除末尾的 '/'，一位位append，遇到./时直接返回，遇到 //删除一位 /
        //这种思路解决不了 /../ 这个字符
        int right = path.length() - 1;
        while(right >= 0 && path.charAt(right) == '/'){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while(right >= 0){
            char c = path.charAt(right);
            if (c == '.'){
                break;
            }
            if (c != '/'){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != '/'){
                sb.append(c);
            }
            right--;
        }
        return sb.reverse().toString();
    }
}
