package tree.findBottomLeftTreeValue513;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Medium
 */
public class FindBottomLeftTreeValue {

    /**
     * 这段代码可以优化的点：
     * 1. 没必要全部保存，可以只记录一个值即可
     * 2. 没必要处理size了
     */

    public int findBottomLeftValue(TreeNode root) {

        //可以层序遍历，如何知道最底层到了？每一层加入数组，返回最后一个
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if(i == 0){
                    res.add(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res.get(res.size() - 1);
    }


    /**
     * 优化代码，需要注意的地方是 先加右节点，最后poll的才是最左节点
     */
    public int findBottomLeftValue2(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while(!queue.isEmpty()){
                 node = queue.pollFirst();

                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
        return node.val;
    }




}
