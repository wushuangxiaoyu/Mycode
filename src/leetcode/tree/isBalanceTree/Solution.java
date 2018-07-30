package leetcode.tree.isBalanceTree;

import leetcode.tree.treeNode.TreeNode;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-22 20:12
 **/
public class Solution {
    public static boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    public static class ReturnType {
        public int level;
        public boolean isB;

        public ReturnType(int l, boolean is) {
            level = l;
            isB = is;
        }
    }

    // process(head, 1)

    public static ReturnType process(TreeNode head, int level) {
        if (head == null) {
            return new ReturnType(level, true);
        }
        ReturnType leftSubTreeInfo = process(head.left, level + 1);
        if (!leftSubTreeInfo.isB) {
            return new ReturnType(level, false);
        }
        ReturnType rightSubTreeInfo = process(head.right, level + 1);
        if (!rightSubTreeInfo.isB) {
            return new ReturnType(level, false);
        }
        if (Math.abs(rightSubTreeInfo.level - leftSubTreeInfo.level) > 1) {
            return new ReturnType(level, false);
        }
        return new ReturnType(Math.max(leftSubTreeInfo.level, rightSubTreeInfo.level), true);
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isBalanced(head));

    }

}
