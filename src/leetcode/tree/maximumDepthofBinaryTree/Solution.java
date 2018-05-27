package leetcode.tree.maximumDepthofBinaryTree;

import leetcode.tree.treeNode.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author Yu
 * @create 2018-05-27 21:10
 **/
public class Solution {
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
}
