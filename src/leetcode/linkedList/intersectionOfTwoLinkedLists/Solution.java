package leetcode.linkedList.intersectionOfTwoLinkedLists;

import leetcode.linkedList.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author Yu
 * @create 2018-07-18 14:05
 **/
public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        int lenA = getLen(pA);
        int lenB = getLen(pB);
        if (lenA > lenB) {
            int i = lenA - lenB;
            while (i > 0) {
                pA = pA.next;
                i--;
            }
        } else {
            int i = lenB - lenA;
            while (i > 0) {
                pB = pB.next;
                i--;
            }
        }
        while(pB!=null){
            if(pA==pB){
                return pB;
            }else {
                pA=pA.next;
                pB=pB.next;
            }
        }
        return null;
    }

    private static int getLen(ListNode head) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }
}
