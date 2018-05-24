package leetcode.linkedList.removeNthNodeFromEndofList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * @author Yu
 * @create 2018-05-24 13:20
 **/
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = head;
        ListNode f = head;
        ListNode spre = null;
        for(int i = 1;i<n;i++){
            f=f.next;
        }
        while(f.next!=null){
            spre = s;
            s=s.next;
            f=f.next;
        }
        if(spre==null){
            head = head.next;
        }
        else{
            spre.next=s.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(2);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(5);
        a1.next=a2;a2.next=a3;a3.next=a4;
        a1=removeNthFromEnd(a1,4);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}