package tree.findDuplicateSubtrees652;

import tree.TreeNode;

import java.util.*;

/**
 * @author lin  2021/12/1 21:03
 */
public class FindDuplicateSubtrees {

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root){

        if (root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String mine = left + "," + right + root.val;
        int count = map.getOrDefault(mine, 0);
        if (count == 1){
            res.add(root);
        }
        map.put(mine, count + 1);
        return mine;
    }

}
