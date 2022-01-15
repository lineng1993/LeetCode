package tree.maximumWidthOfBinaryTree662;


import tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Medium
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 */
public class MaximumWidthOfBinaryTree {


    public int widthOfBinaryTree(TreeNode root) {
        // 避免异常的产生
        if(root==null){
            return 0;
        }
        // 创建一个队列来进行广度优先遍历,注意这个地方就不要使用Queue<TreeNode> queue=new LinkedList<TreeNode>();
        // 因为父类不能调用子类的方法：getLast getFirst
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        // 创建一个变量来保存最大宽度
        int maxwidth=0;
        // 将根节点入队列
        queue.offer(root);
        // 改变根结点的值
        root.val=0;
        while(!queue.isEmpty()){
            TreeNode k=new TreeNode();
            // 记录当前队列中的个数
            int cout=queue.size();
            //创建一个变量来计算每层的宽度
            int width=queue.getLast().val-queue.getFirst().val+1;
            for(int i=0;i<cout;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                    temp.left.val=temp.val*2+1;
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    temp.right.val=temp.val*2+2;
                }
            }
            // 求出每一层的宽度
            // 通过比较找除最大宽度
            if(width>maxwidth){
                maxwidth=width;
            }
        }
        return maxwidth;

    }

    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree2(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {

        /**
         * 满二叉树中，某个结点的左孩子节点位置在 2 ∗ d ，右孩子节点位置在 2 ∗ d + 1
         * 想办法记录当前层其中一侧(最左侧)的节点所在位置，之后遇到当前层的其它节点时计算它们之间的距离。
         * 这里将图片的数字理解成位置，比如 4~6 就是 6 − 4 + 1 = 3 即距离3
         */
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
