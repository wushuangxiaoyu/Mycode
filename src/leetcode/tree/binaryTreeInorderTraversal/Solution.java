package leetcode.tree.binaryTreeInorderTraversal;

import leetcode.linkedList.ListNode;
import leetcode.tree.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 *
 * @author Yu
 * @create 2018-07-19 14:02
 **/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if(root==null){
                TreeNode pop = stack.pop();
                list.add(pop.val);
                root =pop.right;
            }else {
                stack.push(root);
                root =root.left;
            }
        }
        return list;
    }
}
