package leetcode.tree.populatingNextRightPointersInEachNode;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * @author Yu
 * @create 2018-07-20 15:51
 **/
public class Solution {
    public void connect(TreeLinkNode root) {
        process(root);
    }

    private void process(TreeLinkNode root) {
        if(root ==null){
            return;
        }
        if(root.left!=null){
            root.left.next=root.right;
            process2(root.left,root.right);
            process(root.left);
            process(root.right);
        }
    }

    private void process2(TreeLinkNode left, TreeLinkNode right) {
        if(left.right!=null){
            left.right.next=right.left;
            process2(left.right,right.left);
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }
}