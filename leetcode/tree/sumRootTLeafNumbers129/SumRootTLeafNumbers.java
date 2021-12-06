package tree.sumRootTLeafNumbers129;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * @author lin  2021/12/6 19:57
 */
public class SumRootTLeafNumbers {

    public static void main(String[] args) {
        System.out.println(new SumRootTLeafNumbers().sumNumbers(TreeNode.int2TreeNode(1,2,3)));
    }

    public int sumNumbers(TreeNode root) {
        //该题与257一个思路

        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res.stream().mapToInt(Integer::parseInt).sum();
    }

    public void dfs(TreeNode node, List<String>res, String path){
        if (node == null) return;
        path += node.val;

        if(node.left == null && node.right == null){
            res.add(path);
            return;
        }
        if (node.left != null)
            dfs(node.left, res, path);
        if (node.right != null)
            dfs(node.right, res, path);
    }


    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        //先序遍历
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
