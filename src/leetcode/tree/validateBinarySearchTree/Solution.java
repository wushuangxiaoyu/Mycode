package leetcode.tree.validateBinarySearchTree;

import leetcode.tree.treeNode.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Yu
 * @create 2018-05-27 21:17
 **/
public class Solution {

    /**
     * @Description: leetcode上最快的
     */
    public static int lastVal = Integer.MAX_VALUE;
    public static boolean firstNode = true;
    public static boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST2(root.left)){
            return false;
        }
        if(!firstNode && lastVal >= root.val){
            return false;
        }
        //此时 root.val>=lastval 是右子树
        firstNode = false;
        lastVal = root.val;
        if(!isValidBST2(root.right)){
            return false;
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        boolean flag = true;
        if(root!=null){
            Integer last = null;
            Stack<TreeNode> stack = new Stack<>();
            while(root!= null || !stack.isEmpty()){
                if(root !=null){
                    stack.push(root);
                    root= root.left;
                }
                else {
                    TreeNode pop = stack.pop();
                    if(last!=null&&pop.val<=last){
                        flag =false;
                        break;
                    }
                    last = pop.val;
                    root = pop.right;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        TreeNode t1 =new TreeNode(2);
        TreeNode t2 =new TreeNode(1);
        TreeNode t3 =new TreeNode(3);
        t1.left = t2;
        t1.right =t3;
        System.out.println(isValidBST2(t1));
    }
}
