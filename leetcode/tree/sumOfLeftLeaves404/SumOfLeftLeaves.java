package tree.sumOfLeftLeaves404;

import tree.TreeNode;

/**
 * Easy
 * @author lin  2021/12/8 14:29
 */
public class SumOfLeftLeaves {


    public static void main(String[] args) {
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(TreeNode.int2TreeNode(1,2,3,4,5,6,7)));
    }

    public int sumOfLeftLeaves(TreeNode root){
        /*
         * 思路：前中后序遍历？
         * 终止条件（确定左叶子节点）：root.left != null && root.left.left == null && root.left.right == null;
         * 得出DFS：前后序都可以
         * 可以DFS，一般也可以BFS：层序遍历取每层最左边节点即可
         */
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

}
