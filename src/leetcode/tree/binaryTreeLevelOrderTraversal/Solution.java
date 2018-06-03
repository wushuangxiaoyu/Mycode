package leetcode.tree.binaryTreeLevelOrderTraversal;

import leetcode.tree.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author Yu
 * @create 2018-06-02 22:41
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int currentFloor = 1;
        int nextFloor =  0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentFloor--;
            if(node.left!=null){
                queue.offer(node.left);
                nextFloor++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextFloor++;
            }
            list.add(node.val);
            if(currentFloor==0){
                lists.add(list);
                list = new ArrayList<>();
                currentFloor= nextFloor;
                nextFloor = 0;
            }
        }
        return lists;
    }

    static List<List<Integer>> result;

    /**
     * @Description: leetcode 最快的 上使用递归实现
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        result=new ArrayList<>();
        recursion(root, 0);
        return result;
    }
    public void recursion(TreeNode node, int level){
        if(node==null)return;
        if(result.size()<=level)result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        recursion(node.left, level+1);
        recursion(node.right, level+1);
    }
}
