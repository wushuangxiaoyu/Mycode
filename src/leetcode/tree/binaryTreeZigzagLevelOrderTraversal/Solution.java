package leetcode.tree.binaryTreeZigzagLevelOrderTraversal;

import leetcode.tree.treeNode.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author Yu
 * @create 2018-07-19 14:46
 **/
public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();

        int flag = 0;
        int currentFloor = 1;
        int nextFloor = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            if (flag == 0) {
                TreeNode node = queue.pollFirst();
                currentFloor--;
                if (node.left != null) {
                    queue.offer(node.left);
                    nextFloor++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextFloor++;
                }
                list.add(node.val);
                if (currentFloor == 0) {
                    lists.add(list);
                    list = new ArrayList<>();
                    currentFloor = nextFloor;
                    nextFloor = 0;
                    flag = 1;
                }
            } else {
                TreeNode node = queue.pollLast();
                currentFloor--;
                list.add(node.val);
                stack.push(node);
                if (currentFloor == 0) {
                    lists.add(list);
                    list = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        TreeNode pop = stack.pop();
                        if (pop.left != null) {
                            queue.offer(pop.left);
                            nextFloor++;
                        }
                        if (pop.right != null) {
                            queue.offer(pop.right);
                            nextFloor++;
                        }
                    }
                    currentFloor = nextFloor;
                    nextFloor = 0;
                    flag = 0;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode t1 =new TreeNode(1);
        TreeNode t2 =new TreeNode(2);
        TreeNode t3 =new TreeNode(3);
        TreeNode t4 =new TreeNode(4);
        TreeNode t5 =new TreeNode(5);
        TreeNode t6 =new TreeNode(6);
        TreeNode t7 =new TreeNode(7);
        t1.left = t2;
        t1.right =t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        List<List<Integer>> lists = zigzagLevelOrder(t1);
    }
}
