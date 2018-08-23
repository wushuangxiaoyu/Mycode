package leetcode.linkedList.middleOfTheLinkedList;

import leetcode.linkedList.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author Yu
 * @create 2018-07-29 9:43
 **/
public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode q = head;
        ListNode s = head;
        while (q.next != null && q.next.next != null) {
            q=q.next.next;
            s=s.next;
        }
        if(q.next!=null){
            return s.next;
        }else {
            return s;
        }
    }
}
