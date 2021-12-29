package tree.serializeAndDeserializeBinaryTree297;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * Hard
 * @author lin  2021/12/29 11:23
 */
public class SerializeAndDeserializeBinaryTree {
    private final static String SEP = ",";
    private final static String NULL = "#";


    public static void main(String[] args) {
        String s = new SerializeAndDeserializeBinaryTree().serialize(TreeNode.int2TreeNode(1,2,3,4,5,6,7));
        System.out.println(new SerializeAndDeserializeBinaryTree().deserialize(s));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        /**
         * 一开始思路：哪种遍历方式？序列化比较简单，如何反序列化？
         * 前序遍历：
         * 后续遍历：
         * 层序遍历：null使用#代替，每层结束使用!结尾，这样反序列化时也可以。
         */
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    private void serialize(TreeNode root, StringBuilder sb)
    {
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()) return null;
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

}
