package Test.week95;

import leetcode.linkedList.ListNode;

/**
 * ${DESCRIPTION}
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
