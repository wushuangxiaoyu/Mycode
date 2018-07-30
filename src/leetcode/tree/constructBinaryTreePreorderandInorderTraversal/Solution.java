package leetcode.tree.constructBinaryTreePreorderandInorderTraversal;

import leetcode.tree.treeNode.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * @author Yu
 * @create 2018-07-20 14:50
 **/
public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode process(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        if (ps == pe) {
            return new TreeNode(preorder[ps]);
        }
        int k = is;
        while (inorder[k] != preorder[ps]) {
            k++;
        }
        TreeNode node = new TreeNode(preorder[ps]);
        node.left = process(preorder, ps + 1, ps + k - is, inorder, is, k - 1);
        node.right = process(preorder, ps+1+k-is, pe, inorder, k + 1, ie);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
