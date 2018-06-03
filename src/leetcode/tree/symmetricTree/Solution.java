package leetcode.tree.symmetricTree;

import leetcode.tree.treeNode.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author Yu
 * @create 2018-06-03 22:27
 **/
public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    public static boolean recursion(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return(a.val==b.val&&recursion(a.left,b.right)&&recursion(a.right,b.left));
    }
}
