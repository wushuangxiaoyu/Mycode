package leetcode.linkedList.mergeTwoList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Yu
 * @create 2018-05-26 13:17
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }else if(l1==null){
            return l2;
        } else if(l2==null){
            return l1;
        }
        ListNode newList = null;
        ListNode head =null;

        while(l1!=null&&l2!=null){
            ListNode p =l1.val>l2.val?l2:l1;
            if(p==l1){
                l1= l1.next;
            }else {
                l2 =l2.next;
            }
            if(newList == null){
                newList = p;
                head =p;
            }
            else {
                newList.next=p;
                newList = newList.next;
            }
        }
        if(l1==null){
            newList.next=l2;
        }else {
            newList.next=l1;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

