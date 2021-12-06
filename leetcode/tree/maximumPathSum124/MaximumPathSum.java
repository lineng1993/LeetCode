package tree.maximumPathSum124;

import tree.TreeNode;

/**
 * Hard
 * DFS
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * @author lin  2021/12/6 19:11
 */
public class MaximumPathSum {

    public static void main(String[] args) {
        System.out.println(new MaximumPathSum().maxPathSum(TreeNode.int2TreeNode(1,2,3,4,5,6)));
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node){

        /*
         * 思路：路径和？可以参考112，113，257题
         * 难点：任意路径，有点类似437题
         * 思考：标签是DFS，可以前后序遍历，这题来看属于后续遍历
         * 一开始思考误区：节点最大值在加上了跟节点导致算成了 1 + 2->4->5 = 13,其实2->4->5贡献的最大值是7，而不是11
         */
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值

        int maxLeft = maxGain(node.left);
        int maxRight = maxGain(node.right);
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxLeft, 0);
        int rightGain = Math.max(maxRight, 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int curMax = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, curMax);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
