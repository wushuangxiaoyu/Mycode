package leetcode.tree.subtreeOfAnotherTree;

import leetcode.tree.treeNode.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @author Yu
 * @create 2018-08-18 21:19
 **/
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1 = serialize(s);
        String t1 = serialize(t);
        return s1.contains(t1);
    }

    public  String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder("");
        process(root, stringBuilder);
        return stringBuilder.toString();

    }

    private  void process(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("_#");
            return;
        }
        stringBuilder.append(root.val);
        stringBuilder.append("#");
        process(root.left, stringBuilder);
        process(root.right, stringBuilder);
    }

}
