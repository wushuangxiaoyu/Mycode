package leetcode.linkedList.addTwoNumbers2;

import leetcode.linkedList.LinkedListUtil;
import leetcode.linkedList.ListNode;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-17 15:42
 **/
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (result.next == null) {
                result.next = new ListNode(0);
            }
            result = result.next;
            result.val = l1.val + l2.val + result.val;
            if (result.val >= 10){
                result.val = result.val-10;
                result.next = new ListNode(1);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 != null) {
            if (result.next == null) {
                result.next = new ListNode(0);
            }
            result = result.next;
            result.val = result.val + l2.val;
            if(result.val >=10){
                result.next = new ListNode(1);
                result.val=result.val-10;
            }
            while (l2.next != null) {
                if(result.next==null) {
                    result.next = new ListNode(0);
                }
                result.next.val=result.next.val+l2.next.val;
                if(result.next.val >=10){
                    result.next.next = new ListNode(1);
                    result.next.val=result.next.val-10;
                }
                result = result.next;
                l2 = l2.next;
            }
        } else if (l2 == null && l1 != null) {
            if (result.next == null) {
                result.next = new ListNode(0);
            }
            result = result.next;
            result.val = result.val + l1.val;
            if(result.val >=10){
                result.next = new ListNode(1);
                result.val=result.val-10;
            }
            while (l1.next != null) {
                if(result.next==null) {
                    result.next = new ListNode(0);
                }
                result.next.val=result.next.val+l1.next.val;
                if(result.next.val >=10){
                    result.next.next = new ListNode(1);
                    result.next.val=result.next.val-10;
                }
                result = result.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.makeLiskedList(new int[]{9,9,9});
        ListNode l2 = LinkedListUtil.makeLiskedList(new int[]{1});
        ListNode listNode = addTwoNumbers(l1, l2);

    }

}
