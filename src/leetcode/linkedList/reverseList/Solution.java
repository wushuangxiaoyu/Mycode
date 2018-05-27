package leetcode.linkedList.reverseList;

import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * @author Yu
 * @create 2018-05-24 17:54
 **/
public class Solution {
    //todo 递归反转 反转链表
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode p=head.next;
        ListNode n=reverseList2(p);
        head.next=null;
        p.next=head;
        return n;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p!=null){
            stack.push(p);
            p=p.next;
        }
        head = stack.pop();
        p=head;
        while(!stack.isEmpty()){
            p.next=stack.pop();
            p=p.next;
           if(stack.isEmpty()){
               p.next=null;
           }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(2);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(5);
        a1.next=a2;a2.next=a3;a3.next=a4;
        a1=reverseList(a1);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
