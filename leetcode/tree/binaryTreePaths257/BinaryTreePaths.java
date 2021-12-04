package tree.binaryTreePaths257;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * @author lin  2021/12/4 23:01
 */
public class BinaryTreePaths {

    public static void main(String[] args) {


        System.out.println(new BinaryTreePaths().binaryTreePaths(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));

    }

    public List<String> binaryTreePaths(TreeNode root){


        List<String> res = new ArrayList<>();
        buildHelperDfs(root, res, "");
        return res;
    }

    /**
     * dfs
     * @param root TreeNode
     * @param res res
     * @param path path String
     */
    private void buildHelperDfs(TreeNode root, List<String> res, String path){

        path += root.val;
        /*
         * 关键代码：
         * 思考终止条件是什么？什么时候可以被加到数组中？
         * 答：当前节点左右子节点都为null，需要加入到数组中
         */
        if (root.left == null && root.right == null){
            res.add(path);
            return;
        }
        if (root.left != null){
            buildHelperDfs(root.left, res, path + "->");
        }
        if (root.right != null){
            buildHelperDfs(root.right, res, path + "->");
        }
    }

}
