package leetcode.tree.populatingNextRightPointersInEach;

import leetcode.tree.treeNode.TreeNode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * @author Yu
 * @create 2018-07-20 16:17
 **/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return process(root, k).x;
    }

    public Result process(TreeNode root, int k) {
        if (root == null) {
            return new Result(0, null);
        }
        Result left = process(root.left, k);
        if (left.x != null) {
            return left;
        } else if (left.count + 1 == k) {
            return new Result(left.count + 1, root.val);
        }
        Result right = process(root.right, k - left.count-1);
        if (right.x != null) {
            return right;
        } else {
            return new Result(left.count + right.count + 1, null);
        }
    }
}

class Result {
    int count;
    Integer x;

    public Result(int count, Integer x) {
        this.count = count;
        this.x = x;
    }
}
