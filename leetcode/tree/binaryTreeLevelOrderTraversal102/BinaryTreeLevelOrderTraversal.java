package tree.binaryTreeLevelOrderTraversal102;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lin  2021/11/29 20:16
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {


    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size(); //关键代码，levelSize 即为一层的数量
            for (int i = 1; i <= levelSize ; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

}
