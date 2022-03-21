package tree.twoSumInputIsABst653;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy
 * @author lin  2022/3/21 20:03
 */
public class TwoSumInputIsABst {

    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();
        return preOrder(root, set, k);
    }


    private boolean preOrder(TreeNode root, Set<Integer> set, int k){

        if (root == null) return false;
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return preOrder(root.left, set, k) || preOrder(root.right, set, k);
    }

}
