package tree.maxDistance;

import tree.TreeNode;

import javax.sound.sampled.DataLine.Info;

/**
 * @author lin  2022/5/12 14:06
 * b站左神视频题目
 */
public class MaxDistance {



    public static class Info{

        private final int maxDistance;
        private final int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }

        public int getMaxDistance() {
            return maxDistance;
        }

        public int getHeight() {
            return height;
        }
    }


    public int maxDistance(TreeNode root){
        return process(root).getMaxDistance();
    }

    /**
     * 流程分析：
     * 1. root 参与计算，
     * 此时最大值是 leftHeight + 1 + rightHeight
     * 2. root 不参与计算
     * 此时最大值是 max(leftMax, rightMax);
     *
     * 整体来看需要2个信息：maxDistance 和 height，容易知道使用后续遍历，具体计算逻辑还需要思考
     * @param root node
     * @return maxInstance and height of node
     */

    private Info process(TreeNode root){
        if (root == null) return new Info(0, 0);
        Info left = process(root.left);
        Info right = process(root.right);

        int p1 = left.getMaxDistance();
        int p2 = right.getMaxDistance();
        int p3 = left.getHeight() + 1 + right.getHeight();
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(left.getHeight(), right.getHeight()) + 1;
        return new Info(maxDistance, height);
    }
}
