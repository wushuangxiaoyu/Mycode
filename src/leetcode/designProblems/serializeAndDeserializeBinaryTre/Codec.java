package leetcode.designProblems.serializeAndDeserializeBinaryTre;

import leetcode.tree.treeNode.TreeNode;

import java.util.Stack;

/**
 * 二叉树的序列化与反序列化
 *
 * @author Yu
 * @create 2018-07-22 21:55
 **/
public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder("");
        process(root, stringBuilder);
        return stringBuilder.toString();

    }

    private static void process(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("_#");
            return;
        }
        stringBuilder.append(root.val);
        stringBuilder.append("#");
        process(root.left, stringBuilder);
        process(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split("#");
        int i = 1;
        if ("_".equals(split[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean f = true;
        while (i < split.length) {
            if ("_".equals(split[i])) {
                if (f) {
                    node.left = null;
                    f = false;
                } else {
                    node.right = null;
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        node = stack.pop();
                        f = false;
                    }
                }
                i++;
            } else {
                if(f) {
                    node.left = new TreeNode(Integer.valueOf(split[i++]));
                    stack.push(node);
                    node = node.left;
                    f = true;
                }
                else {
                    node.right = new TreeNode(Integer.valueOf(split[i++]));
                    node = node.right;
                    f = true;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(serialize(t1));
        TreeNode deserialize = deserialize(serialize(t1));
    }
}
