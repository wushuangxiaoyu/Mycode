package leetcode.tree.convertSortedArrayToBinarySearchTree;

import leetcode.tree.treeNode.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author Yu
 * @create 2018-06-24 16:16
 **/
public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = null;
        root = process(root, nums, 0, nums.length - 1);
        return root;
    }

    public static TreeNode process(TreeNode root, int[] nums, int start, int end) {
        if (start == end) {
            root = new TreeNode(nums[start]);
            return root;
        }
        int mid = start + (end - start) / 2;
        root = new TreeNode(nums[mid]);
        if (mid != start) {
            root.left = process(root.left, nums, start, mid - 1);
        }
        root.right = process(root.right, nums, mid + 1, end);
        return root;
    }
}
