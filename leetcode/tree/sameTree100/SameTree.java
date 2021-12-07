package tree.sameTree100;

import tree.TreeNode;

/**
 * Easy
 * @author lin  2021/12/7 09:33
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q){

        //简单递归即可，前序遍历
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
