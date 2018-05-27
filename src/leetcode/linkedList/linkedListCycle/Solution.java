package leetcode.linkedList.linkedListCycle;


/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author Yu
 * @create 2018-05-26 12:43
 **/
public class Solution {
    public static boolean hasCycle(ListNode head) {
        if(head == null||head.next==null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast!=null&&fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a= new ListNode(1);
        ListNode b= new ListNode(2);
        a.next=b;
        System.out.println(hasCycle(a));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
